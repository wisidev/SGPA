const monthYearEl = document.getElementById("monthYear");
const calendarDaysEl = document.getElementById("calendarDays");
const btnPrev = document.getElementById("prev");
const btnNext = document.getElementById("next");

let selectedDay = null;

const today = new Date();
let currentMonth = today.getMonth();
let currentYear = today.getFullYear();

function renderCalendar(month, year) {
  calendarDaysEl.innerHTML = "";
  const firstDay = new Date(year, month, 1);
  const lastDay = new Date(year, month + 1, 0);
  const startDay = firstDay.getDay();
  const totalDays = lastDay.getDate();

  const monthNames = [
    "Janeiro",
    "Fevereiro",
    "Março",
    "Abril",
    "Maio",
    "Junho",
    "Julho",
    "Agosto",
    "Setembro",
    "Outubro",
    "Novembro",
    "Dezembro",
  ];

  monthYearEl.textContent = `${monthNames[month]} ${year}`;

  for (let i = 0; i < startDay; i++) {
    const empty = document.createElement("div");
    calendarDaysEl.appendChild(empty);
  }

  for (let d = 1; d <= totalDays; d++) {
    const dayDiv = document.createElement("div");
    dayDiv.textContent = d;

    if (
      d === today.getDate() &&
      month === today.getMonth() &&
      year === today.getFullYear()
    ) {
      dayDiv.classList.add("today");
    }

    dayDiv.addEventListener("click", () => {
      if (selectedDay) selectedDay.classList.remove("selected");
      dayDiv.classList.add("selected");
      selectedDay = dayDiv;
    });

    calendarDaysEl.appendChild(dayDiv);
  }
}

btnPrev.addEventListener("click", () => {
  currentMonth--;
  if (currentMonth < 0) {
    currentMonth = 11;
    currentYear--;
  }
  renderCalendar(currentMonth, currentYear);
});

btnNext.addEventListener("click", () => {
  currentMonth++;
  if (currentMonth > 11) {
    currentMonth = 0;
    currentYear++;
  }
  renderCalendar(currentMonth, currentYear);
});

renderCalendar(currentMonth, currentYear);

function updateClock() {
  const now = new Date();
  const hours = now.getHours().toString().padStart(2, "0");
  const minutes = now.getMinutes().toString().padStart(2, "0");
  const seconds = now.getSeconds().toString().padStart(2, "0");

  document.getElementById(
    "clock"
  ).textContent = `${hours}:${minutes}:${seconds}`;
}

setInterval(updateClock, 1000);
updateClock(); // chama imediatamente

function toggleDetails(element) {
  const li = element.closest("li");
  const detalhesBox = li.querySelector(".detalhes-paciente");
  const statusBox = li.querySelector(".status-tag");
  const pacienteId = li.dataset.id;

  if (
    detalhesBox.style.display === "none" ||
    detalhesBox.style.display === ""
  ) {
    // Oculta o status
    statusBox.style.display = "none";

    // Busca do backend
    fetch(`/paciente/detalhes/${pacienteId}`)
      .then((response) => response.json())
      .then((data) => {
        detalhesBox.innerHTML = `
          <ul>
            <li><strong>Nome:</strong> ${data.nomePaciente}</li>
            <li><strong>Queixa:</strong> ${data.queixaPaciente}</li>
            <li><strong>Endereço:</strong> ${data.endereco}</li>
            <li><strong>Email:</strong> ${data.email}</li>
            <li><strong>Telefone:</strong> ${data.telefone}</li>
            <li><strong>Plano de Saúde:</strong> ${data.planoSaude}</li>
            <li><strong>Sexo:</strong> ${data.sexo}</li>
            <li><strong>Data de Nascimento:</strong> ${data.dataNascimento}</li>
            <li><strong>Tipo Sanguíneo:</strong> ${data.tipoSanguineo}</li>
            <li><strong>Histórico de Doenças:</strong> ${data.historicoDoencas}</li>
            <li><strong>Alergias:</strong> ${data.alergias}</li>
            <li><strong>Medicação:</strong> ${data.medicacao}</li>
          </ul>
        `;
        detalhesBox.style.display = "block";
      })
      .catch((error) => {
        detalhesBox.innerHTML = `<span style="color: red;">Erro ao carregar dados</span>`;
        detalhesBox.style.display = "block";
      });
  } else {
    // Oculta os detalhes e mostra o status novamente
    detalhesBox.style.display = "none";
    statusBox.style.display = "inline-block";
  }
}
