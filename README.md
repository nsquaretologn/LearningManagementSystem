Project: Developing Learning Management System Using Play-Scala Framework

Most learning management systems available online like saki, econf, eledge are developed using Java based web frameworks. Use of Java based web frameworks is less productive than Scala based web framework. The proposed learning management tool is developed using all the advantages of play-Scala framework. 



Project Demo:

Module 1: Post

1. In this module, Students can communicate by adding a new post in the forum.
2. Students can comment on the original post added by the students
3. Edit and Delete options for the post and comments are incorporated in this project.

Module 2: Lecture


1. In this module, the lecturer is given option to add lecture for any particular course.
2. Lecturer can edit/delete the posted lecture.


Module 3: Assignment

1. For each course, assignments can be posted by th professor.
2. Students can view the assignment posted.
3. Professor can delete or edit the uploaded assignment.

This project contains the rest API for all the input requests mentioned below.


Inputs:


Input:  Add Post
curl --header "Content-type: application/json" --request POST --data '{"id" : 2, "e_mail" : "harihdsd", "f_name" : "a","l_name" : "b", "profile_pic" : "path_file", "p_text" : "Text of the post","u_id": 1}' http://localhost:9000/addpost

Input: Add Comment for that post
curl --header "Content-type: application/json" --request POST --data '{"com_id" : 1, "c_id": 2, "p_id": 2,"com_text" : "Text of the Comment","initial" : "CH"}'  http://localhost:9000/addcomment

Input: Edit Post
curl --header "Content-type: application/json" --request POST --data '{"id" : 2, "e_mail" : "harihdsd", "f_name" : "a","l_name" : "b", "profile_pic" : "path_file", "p_text" : "Post Text Edited","u_id": 1,"p_id":2,"p_likes":6}' http://localhost:9000/editpost

Input: Edit Comment
curl --header "Content-type: application/json" --request POST --data '{"com_id" : 1, "c_id": 2, "p_id": 2,"com_text" : "Comment Edited","initial" : "CH"}'  http://localhost:9000/editcomment

Input: Delete Post
curl --header "Content-type: application/json" --request POST --data '{"c_id": 2, "p_id": 2}' http://localhost:9000/deletepost

Input: Delete Comment
curl --header "Content-type: application/json" --request POST --data '{"c_id": 2, "p_id": 2,"com_id":1}' http://localhost:9000/deletecomment

Input: Add Lecture
curl -X POST -F "file_upload=@temp.txt" -F c_id=2 -F lec_id=2 -F l_topic="lec 2" -F l_uploaded_date="Some Date" -F l_summary="sdsdcd" http://localhost:9000/addlecture

Input: Edit Lecture
curl -X POST -F "file_upload=@temp.txt" -F c_id=2 -F lec_id=2 -F l_topic="lec 2" -F l_uploaded_date="Edited Date" -F l_summary="Edited Summary" http://localhost:9000/editlecture

Input: Delete Lecture
curl --header "Content-type: application/json" --request POST --data '{"c_id": 2, "l_id": 2}' http://localhost:9000/deletelecture


Input: Add Assignment
curl -X POST -F "file_upload=@temp.txt" -F c_id=2 -F a_id=2 -F a_topic="Assignment 2" -F a_uploaded_date="Some Date" -F a_due_date="Some Date"  -F a_descripton="sdsdcd" -F a_total_marks=100 http://localhost:9000/addassignment

Input: Edit Assignment
curl -X POST -F "file_upload=@temp.txt" -F c_id=2 -F a_id=2 -F a_topic="Assignment 2" -F a_uploaded_date="Some Date" -F a_due_date="Edited Date"  -F a_descripton="Edited Date" -F a_total_marks=50 http://localhost:9000/editassignment

Input: Delete Assignment
curl --header "Content-type: application/json" --request POST --data '{"c_id": 2, "a_id": 2}' http://localhost:9000/deleteassignment

Add/ Edit Course:

curl --header "Content-type: application/json" --request POST --data '{"c_id" : 2, "instructor_id" : 3, "c_name" : "a","c_summary" : "b"}' http://localhost:9000/addcourse

curl --header "Content-type: application/json" --request POST --data '{"c_id" : 2, "instructor_id" : 2, "c_name" : "new name","c_summary" : "new summary"}' http://localhost:9000/editcourse
