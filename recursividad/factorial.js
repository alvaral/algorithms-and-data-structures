// Función recursiva para calcular el factorial de un número
function factorial(n) {
    if (n === 0 || n === 1) {
      return 1;
    } else {
      return n * factorial(n - 1);
    }
  }
  
  // Prueba la función con un valor
  const numero = 5;
  const resultado = factorial(numero);
  console.log(`El factorial de ${numero} es: ${resultado}`);
  