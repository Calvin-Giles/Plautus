document.getElementById('investmentForm').addEventListener('submit', async function(e) {
    e.preventDefault();

    const data = {
        currentAge: parseInt(document.getElementById('currentAge').value),
        annualIncome: parseFloat(document.getElementById('annualIncome').value),
        yearsUntilRetirement: parseInt(document.getElementById('yearsUntilRetirement').value),
        retirementGoal: parseFloat(document.getElementById('retirementGoal').value),
        growthRate: parseFloat(document.getElementById('growthRate').value)
    };

    try {
        const response = await fetch('http://localhost:8080/api/investment-advice', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });

        const result = await response.json();
        document.getElementById('adviceOutput').textContent = result.advice;
    } catch (error) {
        console.error('Error fetching investment advice:', error);
        document.getElementById('adviceOutput').textContent = 'Error fetching investment advice.';
    }
});
