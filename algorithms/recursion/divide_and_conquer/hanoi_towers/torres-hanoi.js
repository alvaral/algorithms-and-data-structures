function hanoi(n, origen, destino, auxiliar) {
    if (n === 1) {
        const disco = origen.pop();
        destino.push(disco);
        printState();
        return;
    }
    
    hanoi(n - 1, origen, auxiliar, destino);
    
    const disco = origen.pop();
    destino.push(disco);
    printState();
    
    hanoi(n - 1, auxiliar, destino, origen);
}

function printState() {
    console.log(`A: [${A}]`);
    console.log(`B: [${B}]`);
    console.log(`C: [${C}]`);
    console.log('-----------------');
}

var A = [3, 2, 1];
var B = [];
var C = [];

printState();
hanoi(A.length, A, C, B);
