package examination.controller;


import examination.entity.Paper;
import examination.entity.Question.Choicedba;
import examination.entity.Question.Evadba;
import examination.entity.Question.Judgedba;
import examination.entity.Question.Subdba;
import examination.service.ChartService;
import examination.service.EvaluatingService;
import examination.service.ExamService;
import examination.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
    final static String path = "/student/";

    @Autowired
    ExerciseService exerciseService;
    @Autowired
    ExamService examService;
    @Autowired
    ChartService chartService;
    @Autowired
    EvaluatingService evaluatingService;

    @RequestMapping(value = "")
    String index() {
        return "redirect:" + path + "studentpage";
    }
    @RequestMapping(value = "studentpage")
    String studentpage() {
        return path + "studentpage";
    }
    @RequestMapping(value = "student_exercise")
    String student_exercise() {
        return path + "student_exercise";
    }
    @RequestMapping(value = "student_grade")
    String student_grade() {
        return path + "student_grade";
    }
    @RequestMapping(value = "student_status")
    String student_status() {
        return path + "student_status";
    }
    @RequestMapping(value = "student_test")
    String student_test() {
        return path + "student_test";
    }
    @RequestMapping(value = "student_exercise_choice")
    String student_exercise_choice() {
        return path+"student_exercise_choice";
    }
    @RequestMapping(value = "student_exercise_truefalse")
    String student_exercise_truefalse() {
        return path+"student_exercise_truefalse";
    }
    @RequestMapping(value = "student_exercise_sub")
    String student_exercise_sub() {
        return path+"student_exercise_sub";
    }
    @RequestMapping(value = "student_test_ing")
    String student_test_ing() {
        return path+"student_test_ing";
    }
    @RequestMapping(value = "student_chart")
    String studentChart(){
        return path + "student_chart";
    }
    @RequestMapping(value = "student_evaluating_status")
    String studentEvaluatingStatus(){
        return path + "student_evaluating_Status";
    }
    @RequestMapping(value = "student_evaluating_question")
    String studentEvaluatingQuestion(){
        return path + "student_evaluating_question";
    }
    @RequestMapping(value = "student_evaluating_list_select")
    String studentEvaluatingListSelect(){
        return path + "student_evaluating_list_select";
    }
    @RequestMapping(value = "student_evaluating_list_update")
    String studentEvaluatingListUpdate(){
        return path + "student_evaluating_list_update";
    }
    @RequestMapping(value = "student_evaluating_list_insert")
    String studentEvaluatingListInsert(){
        return path + "student_evaluating_list_insert";
    }
    @RequestMapping(value = "student_evaluating_list_delete")
    String studentEvaluatingListDelete(){
        return path + "student_evaluating_list_delete";
    }

    /* ajax异步请求 */

    @RequestMapping(value = "student_exercise_choice_get_question")
    @ResponseBody
    Choicedba student_exercise_choice_get_question(Long id) {
        return  exerciseService.getChoicedbaById_noAns(id);
    }

    @RequestMapping(value = "student_exercise_choice_get_ans")
    @ResponseBody
    Choicedba student_exercise_choice_get_ans(Long id) {
        return  exerciseService.getChoicedbaById_Ans(id);
    }

    @RequestMapping(value = "student_exercise_truefalse_get_question")
    @ResponseBody
    Judgedba student_exercise_truefalse_get_question(Long id) {
        return  exerciseService.getJudgedbaById_noAns(id);
    }

    @RequestMapping(value = "student_exercise_truefalse_get_ans")
    @ResponseBody
    Judgedba student_exercise_truefalse_get_ans(Long id) {
        return  exerciseService.getJudgedbaById_Ans(id);
    }

    @RequestMapping(value = "student_exercise_sub_get_question")
    @ResponseBody
    Subdba student_exercise_sub_get_question(Long id) {
        return  exerciseService.getSubdbaById_noAns(id);
    }

    @RequestMapping(value = "student_exercise_sub_get_ans")
    @ResponseBody
    Subdba student_exercise_sub_get_ans(Long id) {
        return  exerciseService.getSubdbaById_Ans(id);
    }

    @RequestMapping(value = "student_test_get_paper")
    @ResponseBody
    Paper student_test_get_paper(long id) {
        return  examService.getPaperById(id);
    }

    @RequestMapping(value = "student_test_submit",method= RequestMethod.POST)
    @ResponseBody
    String student_test_submit(String ans,long pid,HttpSession httpSession ) {
        System.out.println(" 接收:"+ans);
        System.out.println(" 接收:"+pid);
        long uid = (long) httpSession.getAttribute("userid");
        return examService.submitPapre(uid,pid,ans);
    }

    @RequestMapping(value = "get/chart")
    @ResponseBody
    String getChart(HttpSession session){
        return chartService.studentGetChart((long)session.getAttribute("userid"));
    }

    @RequestMapping(value = "student_eva_get_question",method = RequestMethod.GET)
    @ResponseBody
    Evadba student_eva_get_question(long id){
        return exerciseService.getEvadbaById_noAns(id);
    }

    @RequestMapping(value = "student_get_status",method = RequestMethod.GET)
    @ResponseBody
    List<Map> studentGetStatus(long page){
        final long n = 20;
        long off = (page-1) * n;
        return evaluatingService.get_Status(off,n);
    }

    @RequestMapping(value = "student_evaluating_list_select_get",method = RequestMethod.GET)
    @ResponseBody
    List<Evadba> studentEvaluatingListSelectGet(){
        return exerciseService.getEvadbaByType("查找题");
    }

    @RequestMapping(value = "student_evaluating_list_delete_get",method = RequestMethod.GET)
    @ResponseBody
    List<Evadba> studentEvaluatingListDeleteGet(){
        return exerciseService.getEvadbaByType("删除题");
    }

    @RequestMapping(value = "student_evaluating_list_update_get",method = RequestMethod.GET)
    @ResponseBody
    List<Evadba> studentEvaluatingListUpdateGet(){
        return exerciseService.getEvadbaByType("更新题");
    }

    @RequestMapping(value = "student_evaluating_list_insert_get",method = RequestMethod.GET)
    @ResponseBody
    List<Evadba> studentEvaluatingListInsertGet(){
        return exerciseService.getEvadbaByType("插入题");
    }

    @RequestMapping(value = "student_test_get",method = RequestMethod.GET)
    @ResponseBody
    List<Map> studentTestGet(HttpSession httpSession){
        long uid = (long) httpSession.getAttribute("userid");
        return examService.listPaperBySid(uid);
    }

    @RequestMapping(value = "student_grade_get",method = RequestMethod.GET)
    @ResponseBody
    List<Map> studentGradeGet(HttpSession httpSession){
        long uid = (long) httpSession.getAttribute("userid");
        return examService.listGradeBySid(uid);
    }
    @RequestMapping(value = "paper_tested",method = RequestMethod.GET)
    @ResponseBody
    Boolean paperTested(HttpSession httpSession,long pid){
        long sid = (long) httpSession.getAttribute("userid");
        return examService.paperTested(sid,pid);
    }

    /* 非ajax的POST */

    @RequestMapping(value = "student_evaluating_doPost",method = RequestMethod.POST)
    String studentEvaluatingDoPost(long eid, HttpSession httpSession,String sql2){
        long uid = (long) httpSession.getAttribute("userid");
        evaluatingService.EvaluateSQL(uid,eid,sql2);
        return "redirect:" + path + "student_status";
    }
    @RequestMapping(value = "student_info")
    String student_info() {
        return path+"student_info";
    }
}