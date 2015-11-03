var p1, p2, p; 
var thereIsAWinner = false;
function nameFunction() {
    p1 = document.getElementById("p1").value;
    p2 = document.getElementById("p2").value;
    if (p1 == "" || p2 == "")
    {
	return;
    }
    var names = {
        "name1":p1,
        "name2":p2
    }
    var json = JSON.stringify(names);
    $.ajax({
        url:'/newGame',
        type: 'post',
        datatype: 'json',
        data: json,
        contentType: 'application/json; charset=utf-8',
        success: function() {
            //alert(json);
        }

    });
    var pop;
    pop = document.getElementsByClassName("popUp");
    pop[0].style.visibility="hidden";

    var names = p1 + " VS " + p2;
    document.getElementById("names").innerHTML = names;

    p = "X";
}

function newGame () {
   var pop;
   pop = document.getElementsByClassName("popUp");
   pop[0].style.visibility="visible";
   document.getElementById("1").innerHTML = "";
   document.getElementById("2").innerHTML = "";
   document.getElementById("3").innerHTML = "";
   document.getElementById("4").innerHTML = "";
   document.getElementById("5").innerHTML = "";
   document.getElementById("6").innerHTML = "";
   document.getElementById("7").innerHTML = "";
   document.getElementById("8").innerHTML = "";
   document.getElementById("9").innerHTML = "";
   thereIsAWinner = false;
};

function pressTile(clicked_id) {
    var tile = document.getElementById(clicked_id);
    var number = clicked_id;
    var stuff = {
	"id":number
    }
    var json = JSON.stringify(stuff);
    var makeMove;
    var IsBoardFull;
    var Winner;
    var name; 
    $.ajax({
        url:'/move',
        type: 'post',
        datatype: 'json',
        data: json,
        contentType: 'application/json; charset=utf-8',
	async: false,
        success: function(data) {
	    makeMove = JSON.parse(data).makeMove;
	    IsBoardFull = JSON.parse(data).IsBoardFull;
	    Winner = JSON.parse(data).Winner;
	    name = JSON.parse(data).Name;
        }
    });
    if(tile.innerHTML == "" && makeMove == true && thereIsAWinner == false)
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
    if (Winner && thereIsAWinner == false) { thereIsAWinner = true; alert("We have a winner: " + name)}
    if (IsBoardFull && thereIsAWinner == false) { thereIsAWinner = true; alert("Tie!")}
};

function quitGame()
{
   p1 = "";
   p2 = "";
   var pop;
   pop = document.getElementsByClassName("popUp");
   pop[0].style.visibility="visible";
   document.getElementById("p1").value = "";
   document.getElementById("p2").value = "";
   document.getElementById("1").innerHTML = "";
   document.getElementById("2").innerHTML = "";
   document.getElementById("3").innerHTML = "";
   document.getElementById("4").innerHTML = "";
   document.getElementById("5").innerHTML = "";
   document.getElementById("6").innerHTML = "";
   document.getElementById("7").innerHTML = "";
   document.getElementById("8").innerHTML = "";
   document.getElementById("9").innerHTML = "";
   thereIsAWinner = false;
}
