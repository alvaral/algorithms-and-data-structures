// Función recursiva para calcular el término n de la secuencia de Fibonacci
// Ejemplo: fibonacci(3) 
// = fibonacci(2) + fibonacci(1) 
// = (fibonacci(1) + fibonacci0)) + 1 
// = (1 + 0) + 1 
// = 2
function fibonacci(n) {
    if (n <= 0) {
      return 0;
    } else if (n === 1) {
      return 1;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }
  
// Prueba la función con un valor
const termino = 10;
const resultado = fibonacci(termino);
console.log(`El término ${termino} de la secuencia de Fibonacci es: ${resultado}`);
  