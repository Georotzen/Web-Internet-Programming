var arr1 = [0, 5, 4, 100, -80, 50, -80];
var arr2 = [-5, -4, 0, 4, 5];
var n1 = 5;
var n2 = 10;
var p = "level";
var not_p = "notpalindrome";

function min1(arr) {
    var smallest = arr[0];
    for(var i = 0; i < arr.length; i++) {
        if (arr[i] < smallest) {
            smallest = arr[i];
        }
    }
    return smallest;
}

console.log(min1(arr1));
console.log(min1(arr2));

function min2(arr) {
    var smallest = arr[0];
    arr.forEach(element => {
        if (element < smallest) {
            smallest = element;
        }
    });
    return smallest;
}

console.log(min2(arr1));
console.log(min2(arr2));

function factorial(n) {
   if (n == 0) {
       return 1;
   }
   else {
       return n * factorial(n - 1);
   }
}

console.log(factorial(n1));
console.log(factorial(n2));

function palindrome(s) {
    var isPalindrome = true;
    var arr_isPalindrome = new Array();
    for(var i = 0; i < s.length; i++) {
       arr_isPalindrome[i] = (s.charAt(i) === s.charAt(s.length - i - 1));
    }
    for(var i = 0; i < arr_isPalindrome.length; i++) {
        if (!arr_isPalindrome[i]) {
            isPalindrome = false;
        }
    }
    return isPalindrome;
}

console.log(palindrome(p));
console.log(palindrome(not_p));