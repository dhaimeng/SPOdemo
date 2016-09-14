var Log = {
  elem: false,
  write: function(text){
    if (!this.elem) 
      this.elem = document.getElementById('log');
    this.elem.innerHTML = text;
    this.elem.style.left = (500 - this.elem.offsetWidth / 2) + 'px';
  }
};

function init(){
	//json数据初始化
//	$.get("../localData/JSON/abc.json",function(data){
//        RDFgraph(data);
//        });
	/*调用java文件生成json对象*/
	var data=var1;
	//生成rgraph图，并设置图参数
//	function RDFgraph(data){
		var rgraph = new $jit.RGraph({
		injectInto: 'infovis',
		//背景同心圆设置
		background:{
			CanvasStyles: {
				strokeStyle: '#555'
          }
		},
		//设置鼠标滑轮放大和缩小
		Navigation:{
			enable: true,
			panning: true,
			zooming: 10
		},
		//节点和边格式设置
		Node: {
			color: '#ddeeff'
		},
		Edge: {
			color: '#C17878',
			lineWidth:1.5
		},
		//点击节点前，加载，获取
		onBeforeCompute:function(node){
			Log.write("loading "+node.name+"...");
			$jit.id('inner-details').innerHTML=node.data.relation;
		},
		//生成标签时调用，单击节点移动图
		onCreateLabel:function(domElement,node){
			domElement.innerHTML=node.name;
			domElement.onclick=function(){
				rgraph.onClick(node.id,{
					onComplete:function(){
						Log.write("done");
					}
				});
			};
		},
		//改变标签属性，中间两圈亮
		onPlaceLabel:function(domElement,node){
			var style =domElement.style;
			style.display='';
			style.cursor='pointer';
			if(node._depth <= 1){
				style.fontSize = "0.8em";
                style.color = "#ccc";
			}else if(node._depth ==2){
				style.fontSize = "0.7em";
                style.color = "#494949";
			}else{
				style.display = 'none';
			}
			var left =parseInt(style.left);			//这三行是一些宽度变化匹配？？？
			var w=domElement.offsetWidth;
			style.left=(left-w/2)+'px';
		}

	});
	rgraph.loadJSON(data);
	//动画设置
	rgraph.graph.eachNode(function(n) {
      var pos = n.getPos();
      pos.setc(-200, -200);
    });
	rgraph.compute('end');
	rgraph.fx.animate({
      modes:['polar'],
      duration: 2000
	});
	//在右侧显示根节点相关信息
	$jit.id('inner-details').innerHTML =rgraph.graph.getNode(rgraph.root).data.relation;
//	}
}