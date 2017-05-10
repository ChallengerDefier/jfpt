var categoryNames = ["CR/DR","CT","NJ","MR","MG","BC","心电"];
				
		        // 基于准备好的dom，初始化echarts实例
		        var barChart = echarts.init(document.getElementById('bar_chart'));		
		        // 指定图表的配置项和数据
		        var barOption = {
		            title: {
		                text: '费用类型-数量柱状图'
		            },
		            tooltip: {},
		            toolbox: {
		                show : true,
		                feature : {
		                    dataView : {show: true, readOnly: false},
		                    saveAsImage : {show: true}
		                }
		            },
		            legend: {
		                data:['数量']
		            },
		            xAxis: {
		                data: categoryNames
		            },
		            yAxis: {},
		            series: [{
		                name: '数量',
		                type: 'bar',
		                data: [total.crCount, total.ctCount, total.njCount, total.mrCount, total.mgCount, total.bcCount,total.xdCount]
		            }]
		        };
		
		        // 使用刚指定的配置项和数据显示图表。
		        barChart.setOption(barOption);
				
		    <!-- 饼状图 -->
		    	var pieChart = echarts.init(document.getElementById('pie_chart'));
		    	var pieOption = {
		    		    title : {
		    		        text: '费用类型-数量',
		    		        x:'center'
		    		    },
		    		    tooltip : {
		    		        trigger: 'item',
		    		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    		    },
		    		    toolbox: {
		    		        show : true,
		    		        x : "left",
		    		        feature : {
		    		            dataView : {show: true, readOnly: false},
		    		            saveAsImage : {show: true}
		    		        }
		    		    },
		    		    legend: {
		    		        orient: 'vertical',
		    		        left: 'right',
		    		        data: categoryNames
		    		    },
		    		    series : [
		    		        {
		    		            name: '费用类型',
		    		            type: 'pie',
		    		            radius : '55%',
		    		            center: ['50%', '60%'],
		    		            data:[
		    		                {value:total.crCount, name:'CR/DR'},
		    		                {value:total.ctCount, name:'CT'},
		    		                {value:total.njCount, name:'NJ'},
		    		                {value:total.mrCount, name:'MR'},
		    		                {value:total.mgCount, name:'MG'},
		    		                {value:total.bcCount, name:"BC"},
		    		                {value:total.xdCount, name:"心电"}		    		                
		    		            ],
		    		            itemStyle: {
		    		                emphasis: {
		    		                    shadowBlur: 10,
		    		                    shadowOffsetX: 0,
		    		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		    		                }
		    		            }
		    		        }
		    		    ]
		    		};
		    	pieChart.setOption(pieOption);
	    			    		    	
		    
		    <!-- 折线图 -->
			//获取日期数组
		    function getCategory(data){
	    		var categoryData = [];
	    		for(var i= 0; i<data.length;i++){
		    		categoryData.push(data[i].date);
		    	}
	    		return categoryData;
	    	}
			//获取每种费用类型对应数量的数组
	    	function getValues(name){
	    		var values = [];
	    		switch(name){
	    			case "cr":
	    				for(var i= 0; i<data.length;i++){
	    					values.push(data[i].crCount);
	    				}
	    				break;
	    			case "ct":
	    				for(var i= 0; i<data.length;i++){
	    					values.push(data[i].ctCount);
	    				}
	    				break;
	    			case "nj":
	    				for(var i= 0; i<data.length;i++){
	    					values.push(data[i].njCount);
	    				}
	    				break;
	    			case "mr":
	    				for(var i= 0; i<data.length;i++){
	    					values.push(data[i].mrCount);
	    				}
	    				break;
	    			case "mg":
	    				for(var i= 0; i<data.length;i++){
	    					values.push(data[i].mgCount);
	    				}
	    				break;
	    			case "bc":
	    				for(var i= 0; i<data.length;i++){
	    					values.push(data[i].bcCount);
	    				}
	    				break;
	    			case "xd":
	    				for(var i= 0; i<data.length;i++){
	    					values.push(data[i].xdCount);
	    				}
	    				break;
	    			default:
	    				alert("输入参数错误！");
	    				break;
	    		}
	    		return values;
		    }
		    var lineChart = echarts.init(document.getElementById('line_chart'));

		    	    lineChart.setOption(option = {
		    	       title : {
			    		  text: '费用类型-数量（单位：天）',
			    		  x:'center'
			    		},
		    	        backgroundColor: '#eee',
		    	        animation: false,
		    	        legend: {
		    	            bottom: 10,
		    	            left: 'center',
		    	            data: categoryNames
		    	        },
		    	        tooltip: {
		    	            trigger: 'axis',
		    	            axisPointer: {
		    	                type: 'line'
		    	            }
		    	        },
		                toolbox: {
		                    show: true,
		                    y: 'top',
		                    feature: {
		                        dataView: {show: true, readOnly: false},
		                        saveAsImage: {show: true}
		                    }
		                },		    	     
		    	        brush: {
		    	            xAxisIndex: 'all',
		    	            brushLink: 'all',
		    	            outOfBrush: {
		    	                colorAlpha: 0.1
		    	            }
		    	        },
		    	        grid: [
		    	            {
		    	                left: '10%',
		    	                right: '8%',
		    	                height: '50%'
		    	            },
		    	            {
		    	                left: '10%',
		    	                right: '8%',
		    	                top: '63%',
		    	                height: '16%'
		    	            }
		    	        ],
		    	        xAxis: [
		    	            {
		    	                type: 'category',
		    	                data: getCategory(data),
		    	                scale: true,
		    	                boundaryGap : false,
		    	                axisLine: {onZero: false},
		    	                splitLine: {show: false},
		    	                splitNumber: 20
		    	            },
		    	            {
		    	                type: 'category',
		    	                gridIndex: 1,
		    	                data: getCategory(data),
		    	                scale: true,
		    	                boundaryGap : false,
		    	                axisLine: {onZero: false},
		    	                axisTick: {show: false},
		    	                splitLine: {show: false},
		    	                axisLabel: {show: false},
		    	                splitNumber: 20
		    	            }
		    	        ],
		    	        yAxis: [
		    	            {
		    	                scale: true,
		    	                splitArea: {
		    	                    show: true
		    	                }
		    	            },
		    	            {
		    	                scale: true,
		    	                gridIndex: 1,
		    	                splitNumber: 2,
		    	                axisLabel: {show: false},
		    	                axisLine: {show: false},
		    	                axisTick: {show: false},
		    	                splitLine: {show: false}
		    	            }
		    	        ],
		    	        dataZoom: [
		    	            {
		    	                type: 'inside',
		    	                xAxisIndex: [0, 1],
		    	                start: 98,
		    	                end: 100
		    	            },
		    	            {
		    	                show: true,
		    	                xAxisIndex: [0, 1],
		    	                type: 'slider',
		    	                top: '85%',
		    	                start: 98,
		    	                end: 100
		    	            }
		    	        ],
		    	        series: [
		    	            {
		    	                name: 'CR/DR',
		    	                type: 'line',
		    	                data: getValues("cr"),
		    	                smooth: true,
		    	                lineStyle: {
		    	                    normal: {opacity: 0.5}
		    	                }
		    	            }, 
		    	            {
		    	                name: 'CT',
		    	                type: 'line',
		    	                data: getValues("ct"),
		    	                smooth: true,
		    	                lineStyle: {
		    	                    normal: {opacity: 0.5}
		    	                }
		    	            },
		    	            {
		    	                name: 'NJ',
		    	                type: 'line',
		    	                data: getValues("nj"),
		    	                smooth: true,
		    	                lineStyle: {
		    	                    normal: {opacity: 0.5}
		    	                }
		    	            },
		    	            {
		    	                name: 'MR',
		    	                type: 'line',
		    	                data: getValues("mr"),
		    	                smooth: true,
		    	                lineStyle: {
		    	                    normal: {opacity: 0.5}
		    	                }
		    	            },
		    	            {
		    	                name: 'MG',
		    	                type: 'line',
		    	                data: getValues("mg"),
		    	                smooth: true,
		    	                lineStyle: {
		    	                    normal: {opacity: 0.5}
		    	                }
		    	            },
		    	            {
		    	                name: 'BC',
		    	                type: 'line',
		    	                data: getValues("bc"),
		    	                smooth: true,
		    	                lineStyle: {
		    	                    normal: {opacity: 0.5}
		    	                }
		    	            },
		    	            {
		    	                name: '心电',
		    	                type: 'line',
		    	                data: getValues("xd"),
		    	                smooth: true,
		    	                lineStyle: {
		    	                    normal: {opacity: 0.5}
		    	                }
		    	            }
		    	        ]
		    	    }, true);