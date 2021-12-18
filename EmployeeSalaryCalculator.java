class EmployeeSalary {
    public static int calculateSalary(String[] slabint, String[] perint, String[] ampTaxint, int rebate)
    {
        int totalEmployeeSalary = 0;
        for (int i = 0; i < slabint.length; i++){
            int income = Integer.parseInt(slabint[i]);
            int taxPer = Integer.parseInt(perint[i]);
            int taxPaid = Integer.parseInt(ampTaxint[i]);
            int tax = 0;
            if (income <= 10000)
                tax = taxPer
            
            int taxRemaining = taxPaid -  
            totalEmployeeSalary += (rebate + income);
        }
        return totalEmployeeSalary;
    }

}

public class EmployeeSalaryCalculator {
    public static void main(String[] args) {
        String[] slabint = { "10000", "20000" };
        String[] perint = { "5", "10" };
        String[] ampTaxint = { "1000", "10000" };
        int rebate = 1000;
        System.out.println(EmployeeSalary.calculateSalary(slabint, perint, ampTaxint, rebate));
    }
}