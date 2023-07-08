// JavaScript code
let expenses = [];

function addItem() {
  const itemName = document.getElementById('itemName').value;
  const quantity = parseInt(document.getElementById('quantity').value);
  const price = parseFloat(document.getElementById('price').value);

  if (itemName && quantity && price) {
    const expense = {
      itemName,
      quantity,
      price
    };

    expenses.push(expense);
    displayExpenses();
    calculateTotal();
    clearForm();
  } else {
    alert('Please fill in all the fields.');
  }
}

function displayExpenses() {
  const expenseList = document.getElementById('expenseList');
  expenseList.innerHTML = '';

  expenses.forEach((expense, index) => {
    const row = document.createElement('tr');
    row.innerHTML = `
      <td>${expense.itemName}</td>
      <td>${expense.quantity}</td>
      <td>${expense.price}</td>
      <td><button onclick="deleteItem(${index})">Delete</button></td>
    `;
    expenseList.appendChild(row);
  });
}

function deleteItem(index) {
  expenses.splice(index, 1);
  displayExpenses();
  calculateTotal();
}

function calculateTotal() {
  const totalAmount = document.getElementById('totalAmount');
  let total = 0;

  expenses.forEach((expense) => {
    total += expense.quantity * expense.price;
  });

  totalAmount.textContent = total.toFixed(2);
}

function clearForm() {
  document.getElementById('itemName').value = '';
  document.getElementById('quantity').value = '';
  document.getElementById('price').value = '';
}

