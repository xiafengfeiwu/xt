<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

	<img id="radiatorIcon" src="../assets/img/icons/radiator-icon.png"
		style="display: none" />
	<canvas id="myCanvas" width="800" height="400"></canvas>

	<script type="text/javascript">
		window.onload = function() {
			var myCanvas = document.getElementById('myCanvas').getContext("2d");

			myCanvas.fillStyle = "#efefef";
			myCanvas.fillRect(0, 0, 800, 400);

			myCanvas.lineWidth = 2;
			myCanvas.strokeStyle = "#de4832";

			myCanvas.moveTo(120, 75);
			myCanvas.lineTo(152, 75);
			myCanvas.quadraticCurveTo(157, 75, 162, 85);
			myCanvas.lineTo(162, 130);

			myCanvas.moveTo(256, 75);
			myCanvas.lineTo(288, 75);
			myCanvas.quadraticCurveTo(293, 75, 298, 85);
			myCanvas.lineTo(298, 130);

			myCanvas.moveTo(392, 75);
			myCanvas.lineTo(424, 75);
			myCanvas.quadraticCurveTo(429, 75, 434, 85);
			myCanvas.lineTo(434, 130);

			myCanvas.moveTo(162, 130);
			myCanvas.lineTo(534, 130);
			myCanvas.lineTo(534, 230);

			myCanvas.stroke();

			var img = document.getElementById('radiatorIcon');

			myCanvas.drawImage(img, 64, 64, 62, 57);

			myCanvas.drawImage(img, 200, 64, 62, 57);

			myCanvas.drawImage(img, 336, 64, 62, 57);

			myCanvas.fillStyle = "#FF0000";
			myCanvas.beginPath();
			myCanvas.arc(70, 18, 15, 0, Math.PI * 2, true);
			myCanvas.closePath();
			myCanvas.fill();

			var i = 1;
			var timer = setInterval(function() {
				
				myCanvas.drawImage(img, 336 + ((i++) * 136), 64, 62, 57);
				if (i > 2) {
					window.clearInterval(timer)
				}
			}, 1000);
			var j = 1;
			setInterval(function() {
				j ++;
				myCanvas.fillStyle = "rgb(" + j % 255 + "," + j % 255 + "," + j % 255 + ")";
				myCanvas.beginPath();
				myCanvas.arc(70, 18, 15, 0, Math.PI * 2, true);
				myCanvas.closePath();
				myCanvas.fill();
			}, 100);

		}
	</script>
</body>
</html>