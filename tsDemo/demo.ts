let boolVariable : boolean = false;

let numVariable : number = 50;

let strVariable : string = "Bob";

let oldArray : string[] = ["Alice", "Bob", "Christina", "Dave"]

let tupleVariable : [number,string,boolean] = [5,"Bob",false]

enum streetLight {
    Red,
    Yellow,
    Green
}

let streetLightVar : streetLight = streetLight.Yellow

let anyVar : any = 5

anyVar = "Bob"

let objVar : object = {};

interface ticTacToePlayer{
    name : string;
    turn : boolean;

}

function printPlayerName(player : ticTacToePlayer): string{
    console.log(player.name)
    return player.name;
}

interface Student{
    studentId?: number; //this means the field is optional
    name : string;
}

let s: Student = {name : "David"}

let optionalVariable : Partial<Student> = {};
optionalVariable.name = "Bobbert"
optionalVariable.studentId = 100;

//optionalVariable.newProp = 40;

//let studentWithExtra : Student = {name: "bob" newprop: 40}

interface goodStudent {
    readonly name : string;
    readonly studentId? : number;
}

let readOnlyVar : goodStudent = {name : "bobby", studentId : 5}

//readOnlyVar.studentId=7;

class TalentPathStudent implements Student{
    studentId : number;
    name : string;
    constructor( id: number, name: string){
        this.studentId = id;
        this.name = name;
    }

    printName() : void{
        console.log(this.studentId)
    }
}

let tpStudent : TalentPathStudent = { studentId: 5, name: "bob" };
let tpStudent2 : TalentPathStudent = new TalentPathStudent(5,"bobby");

interface runnable {
    run( printMessage : string );
}

let testRunnable = {
    run : function(printMessage :string) : number{
        console.log (printMessage);
        return 0;
    }
    
}

// let allEqual : (a : number, b : number, c : number) => boolean;

// allEqual = function(a : number, b : number, c : number) : boolean {
//     return true;
// }

// allEqual = function(a : number, b : number, c? : number) : boolean {
//     return true;
// }

// allEqual = function(a : number, b : number) : boolean{
//     return true;
// }

type oneDigitNum = 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9;

let num :oneDigitNum = 5;

num += 1;

for( let i = 0; i <100;i++){
    num++
    console.log(num);
}

let addTwoNumbers = function(a: number, b: number):oneDigitNum{
    return (a+b)as oneDigitNum;
}

console.log(addTwoNumbers(5,6))
//num = addTwoNumbers(5,num);