document.addEventListener("DOMContentLoaded", function() {

const listOf = document.querySelectorAll("td.status");
function color(element) {
    if(element.innerText==="Zgłoszone"){
        element.className = "status red";
    }else if (element.innerText==="W realizacji"){
        element.className = "status yellow";
    }else {
        element.className = "status green"
    }
}

listOf.forEach(color);

});