function logOut() {
    localStorage.setItem("userId", null)
    window.location.href = "../../login/loginhtml/login-page.html"
}