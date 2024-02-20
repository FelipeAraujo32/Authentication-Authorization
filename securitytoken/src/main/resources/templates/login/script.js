const formLogin = document.querySelector("form");

const Ilogin = document.querySelector(".login")
const Ipassword = document.querySelector(".password")



function login (){
    fetch("http://localhost:8080/login",
    {
        headers: {
            'Accept': 'application.json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            login: Ilogin.value,
            password: Ipassword.value,
        })
    })
    .then(function(res){console.log(res)})
    .catch(function(res){console.log(res)})
};

function redirectHome () {
    window.location.href = "../home/home.html";
}

formLogin.addEventListener('submit', function(event){
    event.preventDefault();
    redirectHome()
    login();
});