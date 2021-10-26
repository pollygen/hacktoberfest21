let bttn = document.getElementById("bttn");

bttn.addEventListener("click", function() {
    document.body.style.background = randomColor();
})

function randomColor() {
    return `hsl(${Math.floor(Math.random()*360)},100%,50%)`;
}