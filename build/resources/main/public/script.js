var p1, p2;
var amgems = 1;
function nameFunction() {
    p1 = document.getElementById("p1").value;
    p2 = document.getElementById("p2").value;

    var pop;
    pop = document.getElementsByClassName("popUp");
    pop[0].style.visibility="hidden";

    var names = p1 + " VS " + p2;
    document.getElementById("names").innerHTML = names;

    p = "X";
}

function newGame () {
    var name1 = $("#p1").val();
    var name2 = $("#p2").val();
	var names = {
	    "name1": name1,
	    "name2": name2
	}
		
    /*var json = JSON.stringify(names);
		$.ajax({  
            type: post,
            url: 'TTTWeb/newGame',
            datatype: "json",
	        data: json,
            success: function(response) {
			   
			   
			 }
            });*/
    $(".popUp").hide();
    $("#names").text(name1 + " vs  " + name2);	
};

function pressTile(clicked_id) {
    var tile = document.getElementById(clicked_id);
    if(tile.innerHTML == "")
    {
        tile.innerHTML = p;
        if(p == "X")
        {
            p = "O";
        }
        else
        {
            p = "X";
        }
    }
};

function quitGame()
{

}

function vsP()
{

}

function vsAI()
{
	
}
