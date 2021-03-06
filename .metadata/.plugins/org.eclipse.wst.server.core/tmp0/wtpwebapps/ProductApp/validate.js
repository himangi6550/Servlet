function validate() {
    let name = document.getElementById("nameId").value;
    let percentage = document.getElementById("percentId").value;
    let username = document.getElementById("usernameId").value;
    let password = document.getElementById("passwordId").value;

    if (isBlank(name)) {
        document.getElementById("nameMsg").innerHTML = "Enter name";
        document.getElementById("nameMsg").style.color = "red";
        return false;
    }
    
    if (isBlank(price)) {
        document.getElementById("priceMsg").innerHTML = "Enter price";
        document.getElementById("priceMsg").style.color = "red";
        return false;
    }
    
    if (isBlank(qty)) {
        document.getElementById("quantityMsg").innerHTML = "Enter quantity";
        document.getElementById("quantityMsg").style.color = "red";
        return false;
    }
    
    if (isBlank(manfDate)) {
        document.getElementById("passwordMsg").innerHTML = "Enter password";
        document.getElementById("passwordMsg").style.color = "red";
        return false;
    }
    
    if (isBlank(inspectedDate)) {
        document.getElementById("inspectedDateMsg").innerHTML = "Enter inspected date";
        document.getElementById("inspectedDateMsg").style.color = "red";
        return false;
    }
 
    return true;
}
function isBlank(val) {
    return (val.trim() == "") ? true : false;
}