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
