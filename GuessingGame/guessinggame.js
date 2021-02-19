
let numberSquares = [];
let numberSquaresValues = [];

let populatePage = function() {

    generateNumber();
    let allBodyTags = document.getElementsByTagName("body");

    let bodyTag = allBodyTags[0];
    let gameDivTag = document.createElement("div");
    let textBoxDiv = document.createElement("div");
    bodyTag.style.textAlign="center";
    gameDivTag.style.height="100%";
    gameDivTag.style.width="50%";
    gameDivTag.style.marginLeft="auto";
    gameDivTag.style.marginRight="auto";
    textBoxDiv.style.width="auto";
    textBoxDiv.style.leftMargin="auto";
    textBoxDiv.style.rightMargin="auto";
    textBoxDiv.style.display="inline-block";
    textBoxDiv.style.textAlign="center";
    

    for(let i =0;i<numberSquaresValues.length;i++){
        numberSquares.push(document.createElement("div"));
        numberSquares[i].id = "box"+i;
        numberSquares[i].style.height="25px";
        numberSquares[i].style.width="25%";
        numberSquares[i].style.display="inline-block";
        numberSquares[i].style.border = "1px solid black";
        numberSquares[i].style.boxSizing = "border-box";
        numberSquares[i].style.fontSize = "100%";
        numberSquares[i].style.textAlign = "center";
    }

    for(let i=0;i<numberSquares.length;i++){
        gameDivTag.appendChild( numberSquares[i] );
    }

    bodyTag.appendChild( gameDivTag );

    let guessField = document.createElement("input");
    guessField.style.width="100px";
    guessField.id = "guessInput";
    guessField.style.display="inline-block";

    let submitGuess = document.createElement("button");
    submitGuess.style.width="50px";
    submitGuess.style.display="inline-block";
    submitGuess.id="guessbutton";
    submitGuess.innerHTML="Guess";
    submitGuess.style.margin="auto";
    guessField.style.margin="auto";

    console.log(numberSquaresValues)


    submitGuess.onclick=makeGuess;
    let breakLine = document.createElement("br");
    textBoxDiv.appendChild(guessField);
    textBoxDiv.appendChild(submitGuess);
    bodyTag.appendChild(textBoxDiv);

}

let generateNumber = function(){
    // while(numberSquaresValues[3]===null){
    //     let digit = (Math.random()*10)
    //     numberSquaresValues.push(digit)
    // }
    while(numberSquaresValues.length<4){
        let digit = Math.trunc(Math.random(10)*10).toString();
        if(!numberSquaresValues.includes(digit))
            numberSquaresValues.push(digit)
    }
}

let makeGuess = function(){
    let currentGuess = document.getElementById("guessInput").value;

    for(let i=0;i<4;i++){
        let currentBox = document.getElementById("box"+i);
        currentBox.innerHTML=currentGuess.charAt(i);

        if(currentGuess.charAt(i)===numberSquaresValues[i]){
            currentBox.style.backgroundColor="green";
        } else if(numberSquaresValues.includes(currentGuess.charAt(i))){
            currentBox.style.backgroundColor="yellow";
        } else{ 
            currentBox.style.backgroundColor="red";
        }
        
    }
}

populatePage()