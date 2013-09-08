var express = require('express'),
  app = express();

app.get('/', function (req, res) {
  res.sendfile('graph.html');
});

app.get('/stepsTimeCombined.csv', function (req, res) {
  res.sendfile('stepsTimeCombined.csv');
});

app.get('/calorieViz.csv', function (req, res) {
  res.sendfile('calorieViz.csv');
});

app.get('/stepsViz.csv', function (req, res) {
  res.sendfile('stepsViz.csv');
});

app.get('/stepsGraph', function (req, res) {
  res.sendfile('distanceGraph.html');
});

app.get('/distanceViz.csv', function (req, res) {
  res.sendfile('distanceViz.csv');
});

app.get('/distanceGraph', function (req, res) {
  res.sendfile('distanceGraph.html');
});

app.get('/bubbleData8.json', function (req, res) {
  res.sendfile('bubbleData8.json');
});

app.get('/bubblePack18', function (req, res) {
  res.sendfile('bubblePack18.html');
});

app.get('/bubbleData18.json', function (req, res) {
  res.sendfile('bubbleData18.json');
});

app.get('/bubblePack20', function (req, res) {
  res.sendfile('bubblePack20.html');
});

app.get('/bubbleData20.json', function (req, res) {
  res.sendfile('bubbleData20.json');
});

app.get('/bubblePack10', function (req, res) {
  res.sendfile('bubblePack10.html');
});

app.get('/bubbleData10.json', function (req, res) {
  res.sendfile('bubbleData10.json');
});

app.get('/bubbleDataONE.json', function (req, res) {
  res.sendfile('bubbleDataONE.json');
});


app.get('/bubblePack12', function (req, res) {
  res.sendfile('bubblePack12.html');
});

app.get('/bubbleDatafinal.json', function (req, res) {
  res.sendfile('bubbleDatafinal.json');
});

app.get('/bubblePackfinal', function (req, res) {
  res.sendfile('bubblePackfinal.html');
});

app.get('/bubbleData12.json', function (req, res) {
  res.sendfile('bubbleData12.json');
});

app.get('/bubblePack14', function (req, res) {
  res.sendfile('bubblePack14.html');
});

app.get('/bubbleData14.json', function (req, res) {
  res.sendfile('bubbleData14.json');
});

app.get('/bubblePack16', function (req, res) {
  res.sendfile('bubblePack16.html');
});

app.get('/bubbleData16.json', function (req, res) {
  res.sendfile('bubbleData16.json');
});

app.get('/bubblePack4', function (req, res) {
  res.sendfile('bubblePack4.html');
});

app.get('/bubbleData4.json', function (req, res) {
  res.sendfile('bubbleData4.json');
});

app.get('/bubblePack', function (req, res) {
  res.sendfile('bubblePack.html');
});

app.get('/bubbleData.json', function (req, res) {
  res.sendfile('bubbleData.json');
});

app.get('/cohortAnalysis', function (req, res) {
  res.sendfile('cohortAnalysis.html');
});

app.get('/cohortData.csv', function (req, res) {
  res.sendfile('cohortData.csv');
});

app.get('/logCohortData.csv', function (req, res) {
  res.sendfile('logCohortData.csv');
});

app.get('/colorbrewer.js', function (req, res) {
  res.sendfile('colorbrewer.js');
});

app.get('/cluster2', function (req, res) {
  res.sendfile('clusterBlowUp2.html');
});

app.get('/cluster3', function (req, res) {
  res.sendfile('clusterBlowUp3.html');
});

app.get('/scatter', function (req, res) {
  res.sendfile('scatterPlot.html');
});

app.get('/new.csv', function (req, res) {
  res.sendfile('new.csv');
});

app.get('/1stcluster.csv', function (req, res) {
  res.sendfile('1stcluster.csv');
});

app.get('/2ndcluster.csv', function (req, res) {
  res.sendfile('2ndcluster.csv');
});

app.get('/3rdcluster.csv', function (req, res) {
  res.sendfile('3rdcluster.csv');
});

app.get('/chunk.csv', function (req, res) {
  res.sendfile('chunk.csv');
});

app.get('/chunk1000.csv', function (req, res) {
  res.sendfile('chunk1000.csv');
});

app.get('/chunk10000.csv', function (req, res) {
  res.sendfile('chunk10000.csv');
});

var port = process.env.PORT || 3000;
app.listen(port, function() {
  console.log('Server running at' + port);
});