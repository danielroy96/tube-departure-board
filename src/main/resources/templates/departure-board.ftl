<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Tube Departure Board</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
        integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
  <link href="/css/style.css" rel="stylesheet">
</head>
<body>
<header>
  <nav class="navbar navbar-light bg-light navbar-expand-md fixed-top">
    <div class="float-right mr-3">
      <img class="header-roundel" src="/img/roundel.svg">
    </div>
    <a class="navbar-brand" href="#">Tottenham Court Road</a>
  </nav>
</header>
<main role="main" id="departure-board">
  <button v-for="line in lines" type="button" class="btn btn-line" @click.prevent="setLineId(line.id)" v-bind:style="{
    color: line.foregroundColour,
    'background-color': line.backgroundColour
  }">
    {{line.name}}
  </button>
  <div class="container">
    <div class="row">
      <div v-for="platformName in platformNames" class="col-6">
        <h4>{{platformName}}</h4>
        <ul class="list-group">
          <li class="list-group-item"
            v-for="prediction in orderedPredictions.filter(prediction => prediction.platformName == platformName)">
            <p>
              <span class="badge badge-success badge-tts" v-if="prediction.timeToStation < 60">{{prediction.timeToStation}} secs</span>
              <span class="badge badge-secondary badge-tts" v-if="prediction.timeToStation >= 60">{{~~(prediction.timeToStation/60)}} mins</span>
              {{prediction.destinationName}}
            <span class="badge badge-warning badge-pill">{{prediction.vehicleId}}</span>
            <p>
              <span class="text-muted">{{prediction.currentLocation}}</span>
            </p>
          </li>
        </ul>
      </div>
    </div>
  </div>
</main>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.js"></script>
<script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.jsdelivr.net/npm/lodash@4.17.15/lodash.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script>
    var app = new Vue({
        el: '#departure-board',
        data: {
            stopPointId: '940GZZLUWLO',
            arrivalPredictions: [],
            lines: [],
            lineId: '',
        },
        computed: {
            orderedPredictions: function () {
                return _.orderBy(this.arrivalPredictions, 'timeToStation')
            },
            initialLineId: function () {
                return this.lines[0].id;
            },
            actualLineId: function() {
                return this.lineId || this.initialLineId;
            },
            platformNames: function() {
                return new Set(this.arrivalPredictions
                    .filter(prediction => prediction.lineId === this.actualLineId)
                    .flatMap(prediction => prediction.platformName))
            },
        },
        methods: {
            getData: function () {
                axios
                    .get('/rest/StopPoint/' + this.stopPointId + '/arrivals')
                    .then(response => (this.arrivalPredictions = response.data));
                $('[data-toggle="tooltip"]').tooltip();
            },
            pollData: function () {
                this.polling = setInterval(() => {
                    this.getData()
                }, 30000);
            },
            decrementTimeToStation: function() {
                this.pollingTimeToStation = setInterval(() => {
                    this.arrivalPredictions.forEach(function(part, index) {
                        this[index].timeToStation = this[index].timeToStation - 1;
                    }, this.arrivalPredictions);
                }, 1000);
            },
            setLineId: function(lineId) {
                this.lineId = lineId;
            }
        },
        beforeDestroy() {
            clearInterval(this.polling);
            clearInterval(this.pollingTimeToStation);
        },
        mounted() {
            this.getData();
            this.pollData();
            this.decrementTimeToStation();
            axios
                .get('rest/StopPoint/' + this.stopPointId + '/lines')
                .then(response => this.lines = response.data);
        },
    })
</script>
</body>
</html>