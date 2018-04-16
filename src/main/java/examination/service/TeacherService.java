package examination.service;

import examination.dao.*;
import examination.entity.ChoiceQuestion;
import examination.entity.Paper;
import examination.entity.Student;
import examination.entity.Teacher;
import examination.dao.ChoiceDao;
import examination.dao.ExamDao;
import examination.dao.JudgeDao;
import examination.dao.SubjectDao;
import examination.entity.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TeacherService {
    @Autowired
    ChoiceDao choiceDao;

    @Autowired
    JudgeDao judgeDao;

    @Autowired
    SubjectDao subjectDao;

    @Autowired
    ExamDao examDao;


    public int deleteChoiceQuestion(long id){
        return choiceDao.delete(id);
    }

    public int deleteChoiceQuestionBatch(List<Long>list){
        return choiceDao.deleteByList(list);
    }

    public int updateChoiceQuestion(ChoiceQuestion choiceQuestion){
        return choiceDao.update(choiceQuestion);
    }


    public List<Paper> listExamById(long id){
        return examDao.listExamByTid(id);
    }

    public List<Map> listStudentGrade(long pid){
        return examDao.listStudentGrade(pid);
    }


    public int deleteJudgeQuestion(long id){
        return judgeDao.delete(id);
    }

    public int deleteJudgeQuestionBatch(List<Long>list){
        return judgeDao.deleteByList(list);
    }

    public int updateJudgeQuestion(JudgeQuestion judgeQuestion){
        return judgeDao.update(judgeQuestion);
    }


    public int deleteSubjectQuestion(long id){
        return subjectDao.delete(id);
    }

    public int deleteSubjectQuestionBatch(List<Long>list){
        return subjectDao.deleteByList(list);
    }

    public int updateSubjectQuestion(SubjectQuestion subjectQuestion){
        return subjectDao.update(subjectQuestion);
    }

    public int addChoiceQuestionByExcel(InputStream inputStream) {
        List<ChoiceQuestion> choiceQuestions = new ArrayList<ChoiceQuestion>();
        try {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String question = formatter.formatCellValue(row.getCell(0));
                String option1 = formatter.formatCellValue(row.getCell(1));
                String option2 = formatter.formatCellValue(row.getCell(2));
                String option3 = formatter.formatCellValue(row.getCell(3));
                String option4 = formatter.formatCellValue(row.getCell(4));
                String rightAnswer = formatter.formatCellValue(row.getCell(5));
                ChoiceQuestion choiceQuestion = new ChoiceQuestion(question,option1,option2,option3,option4,rightAnswer);
                choiceQuestions.add(choiceQuestion);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return choiceDao.addByList(choiceQuestions);
    }

    public int addJudgeQuestionByExcel(InputStream inputStream) {
        List<JudgeQuestion> judgeQuestions = new ArrayList<>();
        try {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String question = formatter.formatCellValue(row.getCell(0));
                String rightAnswer = formatter.formatCellValue(row.getCell(1));
                JudgeQuestion judgeQuestion = new JudgeQuestion(question,rightAnswer);
                judgeQuestions.add(judgeQuestion);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return judgeDao.addByList(judgeQuestions);
    }

    public int addSubjectQuestionByExcel(InputStream inputStream) {
        List<SubjectQuestion> judgeQuestions = new ArrayList<>();
        try {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String question = formatter.formatCellValue(row.getCell(0));
                String rightAnswer = formatter.formatCellValue(row.getCell(1));
                SubjectQuestion judgeQuestion = new SubjectQuestion(question, rightAnswer);
                judgeQuestions.add(judgeQuestion);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return subjectDao.addByList(judgeQuestions);
    }

    public List<Map> listPaper(long tid){
        return examDao.listPaper();
    }

    public Map getOnePaperRecord(long pid) {
        return examDao.getOnePaperRecord(pid);

    }

    public Paper getPaper(long pid) {
        return examDao.findPaperById(pid);
    }
}
