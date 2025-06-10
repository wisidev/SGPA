document.addEventListener("DOMContentLoaded", () => {
  const buttons = document.querySelectorAll(".status-buttons button");
  const riskInput = document.getElementById("risk");

  buttons.forEach((button) => {
    button.addEventListener("click", () => {
      const risk = button.getAttribute("data-risk");
      riskInput.value = risk;
      alert("Grau de risco selecionado: " + risk);
    });
  });
});

function setRisk(risk) {
  document.getElementById("risk").value = risk;
  alert("Grau de risco selecionado: " + risk);
}
