function showHelp(helpId) {
  // Esconde todas as caixas de ajuda abertas
  document.querySelectorAll(".help-box").forEach((box) => {
    box.style.display = "none";
  });

  // Mostra a caixa de ajuda clicada
  const helpBox = document.getElementById(helpId);
  if (helpBox) {
    helpBox.style.display = "block";
  }
}

// Quando clicar fora da caixa de ajuda e dos campos interativos, esconde todas as dicas
document.addEventListener("click", function (event) {
  const helpBoxes = document.querySelectorAll(".help-box");
  let clickedInsideHelp = false;

  helpBoxes.forEach((box) => {
    if (box.contains(event.target)) {
      clickedInsideHelp = true;
    }
  });

  // Seleciona todos os elementos de formulário relevantes
  const interactiveElements = document.querySelectorAll(
    "input, textarea, select"
  );
  let clickedInsideField = false;

  interactiveElements.forEach((element) => {
    if (element === event.target) {
      clickedInsideField = true;
    }
  });

  // Se não clicou nem na ajuda nem em um campo, esconde as dicas
  if (!clickedInsideHelp && !clickedInsideField) {
    helpBoxes.forEach((box) => {
      box.style.display = "none";
    });
  }
});
