class Date {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(Date d) {
        this.day = d.day;
        this.month = d.month;
        this.year = d.year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    public void setDay(int day) {
        if(day > 0 && day <= 31)
            this.day = day;
    }
    public void setMonth(int month) {
        if(month > 0 && month <= 12)
            this.month = month;
    }
    public void setYear(int year) {
        if(year > 0)
            this.year = year;
    }
    public String toString() {
        return day + "/" + month + "/" + year;
    }
    public boolean equals(Date d) {
        if(this.day == d.day && this.month == d.month && this.year == d.year)
            return true;
        return false;
    }
}
class Lab {

    
    private static int counter = 0;
    private static final String ID_PREFIX = "LAB";

    
    private String id;
    private String universityName;
    private String departmentName;
    private String sectionName;
    private String labName;
    private int totalComputers;
    private int bookedComputers;
    private Date labDate;

    
    private String generateID() {
        counter++;
        return ID_PREFIX + counter;
    }

    
    public Lab() {
        this("Unknown University", "Unknown Department", "Unknown Section",
                "Default Lab", 30, 0, new Date(1,1,2026));
    }

    
    public Lab(String universityName) {
        this(universityName, "Unknown Department", "Unknown Section",
                "Default Lab", 30, 0, new Date(1,1,2026));
    }

    
    public Lab(String universityName, String departmentName) {
        this(universityName, departmentName, "Unknown Section",
                "Default Lab", 30, 0, new Date(1,1,2026));
    }

    
    public Lab(String universityName, String departmentName, String sectionName) {
        this(universityName, departmentName, sectionName,
                "Default Lab", 30, 0, new Date(1,1,2026));
    }

    
    public Lab(String universityName, String departmentName, String sectionName,
               String labName, int totalComputers, int bookedComputers, Date labDate) {

        this.id = generateID();
        this.universityName = universityName;
        this.departmentName = departmentName;
        this.sectionName = sectionName;
        this.labName = labName;
        this.totalComputers = totalComputers;
        this.bookedComputers = bookedComputers;
        this.labDate = new Date(labDate); // composition
    }

    
    public Lab(Lab l) {
        this.id = generateID();
        this.universityName = l.universityName;
        this.departmentName = l.departmentName;
        this.sectionName = l.sectionName;
        this.labName = l.labName;
        this.totalComputers = l.totalComputers;
        this.bookedComputers = l.bookedComputers;
        this.labDate = new Date(l.labDate);
    }

    
    public static int getTotalLabs() {
        return counter;
    }

    
    public String getId() {
        return id;
    }

    public String getUniversityName() {
        return universityName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getLabName() {
        return labName;
    }

    public int getTotalComputers() {
        return totalComputers;
    }

    public int getBookedComputers() {
        return bookedComputers;
    }

    public Date getLabDate() {
        return labDate;
    }

    
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public void setTotalComputers(int totalComputers) {
        if(totalComputers > 0)
            this.totalComputers = totalComputers;
    }

    public void setBookedComputers(int bookedComputers) {
        if(bookedComputers >= 0 && bookedComputers <= totalComputers)
            this.bookedComputers = bookedComputers;
    }

    public void setLabDate(Date labDate) {
        this.labDate = new Date(labDate);
    }

    public void bookComputers(int count) {
        if(count <= availableComputers()) {
            bookedComputers += count;
            System.out.println(count + " computers booked successfully.");
        } else {
            System.out.println("Not enough computers available.");
        }
    }

    
    public void cancelBooking(int count) {
        if(count <= bookedComputers) {
            bookedComputers -= count;
            System.out.println(count + " computers booking cancelled.");
        } else {
            System.out.println("Invalid cancellation.");
        }
    }

 
    public int availableComputers() {
        return totalComputers - bookedComputers;
    }

    
    public boolean equals(Lab l) {
        return this.id.equals(l.id);
    }

    // toString
    public String toString() {
        return "\nLab ID: " + id +
                "\nUniversity: " + universityName +
                "\nDepartment: " + departmentName +
                "\nSection: " + sectionName +
                "\nLab Name: " + labName +
                "\nTotal Computers: " + totalComputers +
                "\nBooked Computers: " + bookedComputers +
                "\nAvailable Computers: " + availableComputers() +
                "\nDate: " + labDate + "\n";
    }
}
class LabDemo {

    public static void main(String[] args) {

        // Create Date
        Date d1 = new Date(10,3,2026);

        // Different constructors
        Lab lab1 = new Lab();
        Lab lab2 = new Lab("COMSATS University");
        Lab lab3 = new Lab("COMSATS University", "Computer Science", "BCS-C");

        
        Lab lab4 = new Lab("COMSATS University", "Computer Science",
                "BCS-C", "Programming Lab", 40, 5, d1);

        
        Lab lab5 = new Lab(lab4);

        
        lab4.bookComputers(10);

      
        lab4.cancelBooking(3);

       
        System.out.println("Are lab4 and lab5 equal? " + lab4.equals(lab5));

     
        System.out.println(lab1);
        System.out.println(lab2);
        System.out.println(lab3);
        System.out.println(lab4);
        System.out.println(lab5);

        
        System.out.println("Total Lab Objects Created: " + Lab.getTotalLabs());
    }
}