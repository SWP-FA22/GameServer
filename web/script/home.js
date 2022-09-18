const menu = document.getElementById("navbar-default");
const btn_menu = document.getElementById("btn-menu");

btn_menu.addEventListener("click", () => {
    menu.classList.toggle("hidden");
});
