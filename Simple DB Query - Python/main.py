
#creating the Students Array
with open("Students.txt", "r") as studentFile:
    # array to store all of the read elements in tbe Students.txt file
    StudentsArray = [];
    # we are going to be storing the elements into a dictionary, using delimitations
    for line in studentFile:
        #dictionary for each line
        individualStudent = {}
        # separate each key-pair elements with a comma
        keyPair = line.strip().split(", ")

        # partition of each key-pair into a key and a value with the delimitor :
        for part in keyPair:
            key, value = part.split(": ")
            # add the key-pair in dictionary
            individualStudent[key] = value
        StudentsArray.append(individualStudent)
print(StudentsArray)

#create the Courses, same concept as the Students
with open("Courses.txt", "r") as coursesFile:
    CoursesArray = [];

    for line in coursesFile:
        individualCourse = {}
        keyPair = line.strip().split(", ")
        for part in keyPair:
            key, value = part.split(": ")
            individualCourse[key] = value

        CoursesArray.append(individualCourse)
print(CoursesArray)

#create the Courses_Enrolled, same concept as Courses and Students
with open("Courses_Enrolled.txt", "r") as cEnrolledFile:
    Courses_EnrolledArray = []

    for line in cEnrolledFile:
        individualCE = {}
        keyPair = line.strip().split(", ")

        for part in keyPair:
            key, value = part.split(": ")
            individualCE[key] = value
        Courses_EnrolledArray.append(individualCE)
print(Courses_EnrolledArray)
print(" ")

# Create an array in which we are going to be storing the elements of the query
queryStudents = [];

# finding the students who have a grade above B+, iterate through all of the 3 arrays
for courses_enr in Courses_EnrolledArray:
    for cour in CoursesArray:
        # joining of CID from Courses_enrolled with Courses
        if (courses_enr["CID"] == cour['CID'] and cour['Name'] == "Databases"):
            for stud in StudentsArray:
                # joining of SID from Courses_Enrolled with Students
                if (courses_enr["SID"] == stud['SID']):
                    # grades to consider => A+, A, A-, B+
                    if (courses_enr["Grade"] == "B+" or courses_enr["Grade"] == "A+" or courses_enr["Grade"] == "A-" or
                            courses_enr["Grade"] == "A"):
                        # add the elements into the array
                        queryStudents.append({stud['Name'], stud['SID']});

print("The following students are the ones who received grades greater than B+: ");
print(queryStudents);
