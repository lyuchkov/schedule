package ru.lyuchkov.service;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import ru.lyuchkov.container.ScheduleRepository;
import ru.lyuchkov.entity.Group;
import ru.lyuchkov.entity.Session;
import ru.lyuchkov.genetic_algorithm.Data;
import ru.lyuchkov.infostructure.annotations.InjectByType;
import ru.lyuchkov.infostructure.annotations.Singleton;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Singleton
public class SerializationService {
    @InjectByType
    ScheduleService scheduleService;

    final String filename = "src/main/resources/output/table.xls";

    public boolean createExcelTable(){
        try {
        HSSFWorkbook workbook = new HSSFWorkbook();

        List<Session> list = scheduleService.getRepository().getCurrentState();
        HSSFSheet sheet = workbook.createSheet("Расписание");
        HSSFRow rowhead = sheet.createRow(0);

        rowhead.createCell(0).setCellValue("Группа");
        rowhead.createCell(1).setCellValue("Предмет");
        rowhead.createCell(2).setCellValue("Преподаватель");
        rowhead.createCell(3).setCellValue("Аудитория");
        rowhead.createCell(4).setCellValue("Время");


        int num = 1;
        for (Session s:
             list) {
            HSSFRow temp = sheet.createRow(num);
            num++;
            temp.createCell(0).setCellValue(s.getGroup().getName());
            temp.createCell(1).setCellValue(s.getDiscipline().getName());
            temp.createCell(2).setCellValue(s.getEducator().getExportName());
            temp.createCell(3).setCellValue(s.getRoom().getName());
            temp.createCell(4).setCellValue(s.getTime().toString());
        }
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.close();
        workbook.close();
        return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
