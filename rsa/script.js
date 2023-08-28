const p = 3,
  q = 13;

const n = p * q;

const temp = (p - 1) * (q - 1);

let e;
function gcd(a, b) {
  let t;
  if (b < a) {
    t = b;
    b = a;
    a = t;
  }
  while (b != 0) {
    t = a;
    a = b;
    b = t % b;
  }
  return a;
}

function publicKey() {
  for (let i = 2; i < temp; i++) {
    if (gcd(temp, i) == 1) {
      e = i;
      break;
    }
  }
  document.getElementById("public").innerHTML = e + "," + n;
}

function encryption() {
  let plainText = document.forms[0].plainText.value;
  //   console.log(plainText);
  let cipherText = Math.pow(plainText, e) % n;
  document.getElementById("encrypt").innerHTML = cipherText;
}

let dFinal;
function decryption() {
  let k = 1;
  while (true) {
    let d = (1 + k * temp) / e;
    //console.log(d);
    if (d % 1 == 0) {
      dFinal = d;
      break;
    }
    k++;
  }

  let c = document.forms[1].cipherText.value;
  //console.log(c);
  let m = Math.pow(c, dFinal) % n;
  document.getElementById("decrypt").innerHTML = m;
}
