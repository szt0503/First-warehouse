function animate(obj, target,back) {
				clearInterval(obj.timer);

				obj.timer = setInterval(function() {
					var step = (target - obj.offsetLeft) / 20;//数值越打缓动越明显
					step = step>0?Math.ceil(step):Math.floor(step);
					if (obj.offsetLeft == target) {
						clearInterval(obj.timer);
					}
					//把每次+1改为公式
					obj.style.left = obj.offsetLeft + step + 'px';
				}, 15)
			}