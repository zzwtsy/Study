function changeTheme() {
  let link = document.getElementById("themeCss");
  let id = document.getElementById("changeTheme");
  if ($("#changeTheme").attr("class") === "moon pr-3") {
    link.href = "./css/bootstrap.light.min.css";
    id.src = "./img/theme/sun.png";
    id.className = "sun pr-3";
  } else {
    link.href = "./css/bootstrap.dark.min.css";
    id.src = "./img/theme/moon.png";
    id.className = "moon pr-3";
  }
}
