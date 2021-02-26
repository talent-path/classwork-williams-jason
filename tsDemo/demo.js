var boolVariable = false;
var numVariable = 50;
var strVariable = "Bob";
var oldArray = ["Alice", "Bob", "Christina", "Dave"];
var tupleVariable = [5, "Bob", false];
var streetLight;
(function (streetLight) {
    streetLight[streetLight["Red"] = 0] = "Red";
    streetLight[streetLight["Yellow"] = 1] = "Yellow";
    streetLight[streetLight["Green"] = 2] = "Green";
})(streetLight || (streetLight = {}));
var streetLightVar = streetLight.Yellow;
var anyVar = 5;
anyVar = "Bob";
var objVar = {};
function printPlayerName(player) {
    console.log(player.name);
    return player.name;
}
var s = { name: "David" };
var optionalVariable = {};
optionalVariable.name = "Bobbert";
optionalVariable.studentId = 100;
var readOnlyVar = { name: "bobby", studentId: 5 };
//readOnlyVar.studentId=7;
var TalentPathStudent = /** @class */ (function () {
    function TalentPathStudent(id, name) {
        this.studentId = id;
        this.name = name;
    }
    TalentPathStudent.prototype.printName = function () {
        console.log(this.studentId);
    };
    return TalentPathStudent;
}());
var tpStudent = { studentId: 5, name: "bob" };
var tpStudent2 = new TalentPathStudent(5, "bobby");
var testRunnable = {
    run: function (printMessage) {
        console.log(printMessage);
        return 0;
    }
};
var num = 5;
num += 1;
for (var i = 0; i < 100; i++) {
    num++;
    console.log(num);
}
var addTwoNumbers = function (a, b) {
    return (a + b);
};
console.log(addTwoNumbers(5, 6));
//num = addTwoNumbers(5,num);
