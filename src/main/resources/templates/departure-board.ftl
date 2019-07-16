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
  <#--<link href="/css/style.css" rel="stylesheet">-->
</head>
<body>
<style>
  @font-face {
    font-family: 'Johnston';
    src: url('ttf/johnston.ttf') format('truetype');
  }
</style>
<div class="">
  <div class="float-left">
    <p style="padding: 1em; font-family: 'Johnston'; font-size: 2.5em;">Embankment</p>
  </div>
  <div class="float-right">
    <img src="/img/roundel.svg" style="height: 8em; padding: 1em;"/>
  </div>
</div>
<div class="row">
  <ul>
    <#list arrivalPredictions?sort_by("timeToStation") as prediction>
      <li>
        <b>${prediction.lineName}</b><#if prediction.destinationName??> - ${prediction.destinationName} (${prediction.platformName})</#if> <span class="badge badge-success">${prediction.vehicleId}</span><br>
        ${prediction.timeToStation}secs - ${prediction.currentLocation}
      </li>
    </#list>
  </ul>
</div>

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
</body>
</html>