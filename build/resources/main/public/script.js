var p1, p2;

function nameFunction() {
    p1 = document.getElementById("p1").value;
    p2 = document.getElementById("p2").value;

    var pop;
    pop = document.getElementsByClassName("popUp");
    pop[0].style.visibility="hidden";

    var names = p1 + " VS " + p2;
    document.getElementById("names").innerHTML = names;
}

function newGame()
{
	$.ajax({
                        type: 'POST',
                        url: '/newGame',
                        data: null,
                        datatype: "json"
                    }).done(function(data) {
                        updateElements(data);
                            };
                        };
                    });

}

function quitGame()
{

}

function vsP()
{

}

function vsAI()
{
	
}
