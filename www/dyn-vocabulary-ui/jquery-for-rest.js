$(document).ready(function(){
$.ajax({
        "url" : "http://localhost:8080/problem-word-list",
        "type" : "GET",
        "dataType": "json",
        "success" : function(data) {
                var projectData=data;
                var tableProblem = document.getElementById("tbl-problem-words");
                var txt='words:';
                for (i in projectData.problemWords) {
                  txt += projectData.problemWords[i].wordEn.concat(', ');
                  tableProblem.rows[i].cells[0].innerHTML = projectData.problemWords[i].wordEn;
                }
                $("#projectInfo").text(txt);
        },
        "error" : function(response,error)
        {
            console.log("ERROR: "+JSON.stringify(response));
        }
    });

$.ajax({
        "url" : "http://localhost:8080/common-word-list",
        "type" : "GET",
        "dataType": "json",
        "success" : function(data) {
                var projectData=data;
                var tableCommon = document.getElementById("tbl-common-words");
                var txt='words:';
                for (i in projectData.commonWords) {
                  txt += projectData.commonWords[i].wordEn.concat(', ');
                  tableCommon.rows[i].cells[0].innerHTML = projectData.commonWords[i].wordEn;
                }
                $("#projectInfo").text(txt);
        },
        "error" : function(response,error)
        {
            console.log("ERROR: "+JSON.stringify(response));
        }
    });

});