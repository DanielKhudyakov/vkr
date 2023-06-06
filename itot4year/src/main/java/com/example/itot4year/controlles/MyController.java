package com.example.itot4year.controlles;

import com.example.itot4year.libs.ExcelParsing;
import com.example.itot4year.models.*;
import com.example.itot4year.repo.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class MyController {

    // значения столбцов для выбора данных в шаблонных файлах


    int COMP_CODE = 2;
    int TYPE_CONTROL = 2;
    int START_TYPE_CONTROL = 3;
    int START_TYPE_ACTIVITY = 18;
    int LINE_DIRECTION = 17;
    int COLUMN_DIRECTION = 1;
    int LINE_STANDART = 30;
    int COLUMN_STANDART = 19;
    int LINE_PROFILE = 18;
    int COLUMN_PROFILE = 1;
    int LINE_YEAR = 28;
    int COLUMN_YEAR = 19;
    int LINE_STATEMENT = 12;
    int COLUMN_STATEMENT = 0;
    int LINE_QUALIFICATION = 28;
    int COLUMN_QUALIFICATION = 0;
    int LINE_FORM = 30;
    int COLUMN_FORM = 0;
    int START_DISCIPLINE = 5;




    /** экземпляры хранилищ */
    @Autowired
    private CompetenceRepository competenceRepository;
    @Autowired
    private TypeOfControlRepository typeOfControlRepository;
    @Autowired
    private TypeOfActivityRepository typeOfActivityRepository;
    @Autowired
    private Educational_standardRepository educationalStandardRepository;
    @Autowired
    private DirectionRepository directionRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ProfileOfDirectionRepository profileOfDirectionRepository;
    @Autowired
    private CurriculaRepository curriculaRepository;
    @Autowired
    private DisciplinesRepository disciplinesRepository;
    @Autowired
    private CompetenciesDisciplineRepository competenciesDisciplineRepository;
    @Autowired
    private ControlRepository controlRepository;
    @Autowired
    private RHDSRepository rhdsRepository;

    /** имена страниц */

    Map<String, String> SHEET = Map.of(
            "competencies", "Компетенции",
            "curricula", "План",
            "titlePage", "Титул"
    );
    String nameFile = null;

    Map<String, Integer> constValue = new HashMap<>();



    /**
     * парсер номеров семестров
     * @param s номера семестров без разделителей
     * @return
     */
    private List<String> parserSemester(String s) {
        List<String> examen = new ArrayList<>();
        if (Integer.parseInt(s) > 10) {
            examen = List.of(s.strip().split(""));
            if (examen.get(examen.size() - 1).equals("0")) {
                examen.remove(examen.size() - 1);
                examen.remove(examen.size() - 1);
                examen.add("10");
            }
        } else {
            examen.add(s.strip());
        }
        return examen;
    }

    /**
     * Добавление компетенций в БД
     * @param sheet - страница Excel файла
     * @throws IOException
     */
    private void addCompetence (HSSFSheet sheet) throws IOException {
        int i = constValue.get("COMP_CODE");
        while (ExcelParsing.readExcel(sheet, i, 3) != null) {
            List<String> s = ExcelParsing.readExcelCell(sheet, i, 1, 3);
            if (s.get(0) != "0") {
                competenceRepository.save(new Competence(s));
            }
            i++;
        }
    }

    /**
     * Добавление типа контроля в БД
     * @param sheet - страница Excel файла
     * @throws IOException
     */
    private void addTypeControl(HSSFSheet sheet) throws IOException {
        int j = constValue.get("TYPE_CONTROL");
        List<String> str = ExcelParsing.readExcelCell(sheet, j, constValue.get("START_TYPE_CONTROL"),
                constValue.get("START_TYPE_CONTROL")+4);
        for (String el : str) {
            if (!typeOfControlRepository.existsTypeOfControlByNameTypeOfControl(el)) {
                typeOfControlRepository.save(new TypeOfControl(el));
            }
        }
    }

    /**
     * Добавление типов занятий
     * @param sheet - страница Excel файла
     * @throws IOException
     */
    private void addTypeActivity(HSSFSheet sheet) throws IOException {
        int j = constValue.get("TYPE_CONTROL");
        List<String> str2 = ExcelParsing.readExcelCell(sheet, j, constValue.get("START_TYPE_ACTIVITY"),
                constValue.get("START_TYPE_ACTIVITY")+4);
        for (String el : str2) {
            if (!typeOfActivityRepository.existsTypeOfActivityByNameTypeOfActivity(el)) {
                typeOfActivityRepository.save(new TypeOfActivity(el));
            }
        }
    }

    /**
     * Добавление образовательного стандарта
     * @param sheet - страница Excel файла
     * @throws IOException
     */
    private void addStandart (HSSFSheet sheet) throws IOException {
        String d = ExcelParsing.readExcel(sheet, constValue.get("LINE_STANDART"), constValue.get("COLUMN_STANDART"));
        String[] spl = d.strip().split(" ");
        String mi = ExcelParsing.readExcel(sheet, constValue.get("LINE_DIRECTION"),
                constValue.get("COLUMN_DIRECTION")).strip();
        int index = mi.indexOf(" ");
        educationalStandardRepository.save(new Educational_standard(Integer.parseInt(spl[1]), spl[3].strip(), mi.substring(index + 1)));
    }

    /**
     * Добавление направления
     * @param sheet - страница Excel файла
     * @throws IOException
     */
    private void addDirection(HSSFSheet sheet) throws IOException {
        String mi = ExcelParsing.readExcel(sheet, constValue.get("LINE_DIRECTION"),
                constValue.get("COLUMN_DIRECTION")).strip();
        directionRepository.save(new Direction(mi));
    }

    /**
     * Добавление профиля
     * @param sheet - страница Excel файла
     * @throws IOException
     */
    private void  addProfile(HSSFSheet sheet) throws IOException {
        String prof = ExcelParsing.readExcel(sheet, constValue.get("LINE_PROFILE"),
                constValue.get("COLUMN_PROFILE")).strip();
        if (!profileRepository.existsProfileByNameProfile(prof)) {
            profileRepository.save(new Profile(prof));
        }
    }

    /**
     * Добавление профилей направлений
     * @param sheet - страница Excel файла
     * @throws IOException
     */
    private void addProfileDirection(HSSFSheet sheet) throws IOException {
        String mi = ExcelParsing.readExcel(sheet, constValue.get("LINE_DIRECTION"),
                constValue.get("COLUMN_DIRECTION")).strip();
        String prof = ExcelParsing.readExcel(sheet, constValue.get("LINE_PROFILE"),
                constValue.get("COLUMN_PROFILE")).strip();
        if (!profileOfDirectionRepository.existsProfileOfDirectionByCodeDirectionAndCodeProfile
                (mi.split(" ")[0], profileRepository.findByNameProfile(prof).getCodeProfile()
                )) {
            profileOfDirectionRepository.save(new ProfileOfDirection(
                    profileRepository.findByNameProfile(prof).getCodeProfile(),
                    mi.split(" ")[0]));
        }
    }

    /**
     * Добавление учебного плана
     * @param sheet -страница Excel файла
     * @throws IOException
     */
    private void addCurricula(HSSFSheet sheet) throws IOException {
        String d = ExcelParsing.readExcel(sheet, constValue.get("LINE_STANDART"),
                constValue.get("COLUMN_STANDART"));
        String[] spl = d.strip().split(" ");
        String mi = ExcelParsing.readExcel(sheet, constValue.get("LINE_DIRECTION"),
                constValue.get("COLUMN_DIRECTION")).strip();
        String prof = ExcelParsing.readExcel(sheet,
                constValue.get("LINE_PROFILE"), constValue.get("COLUMN_PROFILE")).strip();
        String year = ExcelParsing.readExcel(sheet,
                constValue.get("LINE_YEAR"), constValue.get("COLUMN_YEAR")).strip();
        if (!curriculaRepository.existsCurriculaByNameCurricula("b09030204_20_1_II_plx")) {
            curriculaRepository.save(new Curricula(
                    nameFile,
                    Integer.parseInt(year), Integer.parseInt(spl[1]),
                    profileOfDirectionRepository.findProfileOfDirectionByCodeDirectionAndAndCodeProfile(
                            mi.split(" ")[0],
                            profileRepository.findByNameProfile(prof).getCodeProfile()
                    ).getId_pd(),
                    ExcelParsing.readExcel(sheet,
                            constValue.get("LINE_STATEMENT"),constValue.get("COLUMN_STATEMENT")),
                    ExcelParsing.readExcel(sheet,
                            constValue.get("LINE_QUALIFICATION"),constValue.get("COLUMN_QUALIFICATION"))
                            .split(":")[1].strip(),
                    ExcelParsing.readExcel(sheet,LINE_FORM,COLUMN_FORM).split(":")[1].strip()
            ));
        }
    }

    /**
     * Добавление компетенций дисциплины
     * @param sheet - страница Excel файла
     * @throws IOException
     */
    private void addCompetenciesDiscipline(HSSFSheet sheet) throws IOException {
        int y = constValue.get("COMP_CODE");
        String w = "";
        String l = "";
        while (ExcelParsing.readExcel(sheet, y, 1) != null) {
            if (!ExcelParsing.readExcel(sheet, y, 1).equals("0")) {
                w = ExcelParsing.readExcel(sheet, y, 1);
            } else {
                l = ExcelParsing.readExcel(sheet, y, 2);
                if (!competenciesDisciplineRepository.existsCompetenciesDisciplineByCodeCompetenceAndCodeDiscipline(w,
                        disciplinesRepository.findDisciplinesByIndexDisciplineAndCodeCurricula(l,
                                curriculaRepository.findCurriculaByNameCurricula("b09030204_20_1_II_plx")
                                        .getCode_curricula()).getCode_discipline())) {
                    competenciesDisciplineRepository.save(new CompetenciesDiscipline(
                            w, disciplinesRepository.findDisciplinesByIndexDisciplineAndCodeCurricula(l,
                            curriculaRepository.findCurriculaByNameCurricula("b09030204_20_1_II_plx").getCode_curricula()).getCode_discipline()
                    ));

                }
            }
            y++;
        }
    }

    /**
     * Добавление дисциплин, контроля и занятий по ним
     * @param sheet - страница Excel файла
     * @param controlType - список типов контролей
     * @param activityType - список типов занятий
     * @throws IOException
     */
    private void addDisciplineAndControlAndActivity(HSSFSheet sheet, List<String> controlType, List<String> activityType) throws IOException {
        int g = constValue.get("START_DISCIPLINE");
        int step = 8;
        //int diap = 5;
        int start = 23;
        int sem2 = 17;
        int fff = sem2;
        while (ExcelParsing.readExcel(sheet, g, 1) != null) {
            List<String> strDis = ExcelParsing.readExcelCell(sheet, g, 1, 15);
            if (!disciplinesRepository.existsDisciplinesByIndexDisciplineAndCodeCurricula(strDis.get(0),
                    curriculaRepository.findCurriculaByNameCurricula("b09030204_20_1_II_plx").getCode_curricula())) {
                if (!(strDis.get(0).equals("0") & strDis.get(1).equals("0"))) {
                    Disciplines disp = new Disciplines(strDis.get(0), strDis.get(1),
                            curriculaRepository.findCurriculaByNameCurricula("b09030204_20_1_II_plx").getCode_curricula(),
                            Double.parseDouble(strDis.get(8)), Double.parseDouble(strDis.get(9)),
                            Double.parseDouble(strDis.get(11)), Double.parseDouble(strDis.get(12)),
                            Double.parseDouble(strDis.get(13)), Double.parseDouble(strDis.get(14)));
                    disciplinesRepository.save(disp);

                    ///контроль

                    if (!strDis.get(2).equals("0")) {
                        List<String> examen = parserSemester(strDis.get(2));
                        for (String b : examen) {
                            System.out.println((Integer.parseInt(b)-1)*step);
                            /*System.out.println("---" + ExcelParsing.readExcel(sheet2,g,sem1
                                    + (Integer.parseInt(b)-1)*step));*/
                            controlRepository.save(new Control(
                                    Double.parseDouble(ExcelParsing.readExcel(
                                            sheet,g,start + (Integer.parseInt(b)-1)*step)),
                                    Integer.parseInt(b),
                                    typeOfControlRepository.findTypeOfControlByNameTypeOfControl(controlType.get(0)).getCode_type_control(),
                                    disp.getCode_discipline()
                            ));
                        }
                    }

                    if (!strDis.get(3).equals("0")) {
                        List<String> examen = parserSemester(strDis.get(3));
                        for (String b : examen) {
                            System.out.println((Integer.parseInt(b)-1)*step);
                            /*System.out.println("---" + ExcelParsing.readExcel(sheet2,g,sem1
                                    + (Integer.parseInt(b)-1)*step));*/
                            controlRepository.save(new Control(
                                    Double.parseDouble(ExcelParsing.readExcel(
                                            sheet,g,start + (Integer.parseInt(b)-1)*step)),
                                    Integer.parseInt(b),
                                    typeOfControlRepository.findTypeOfControlByNameTypeOfControl(controlType.get(1)).getCode_type_control(),
                                    disp.getCode_discipline()
                            ));
                        }
                    }

                    if (!strDis.get(4).equals("0")) {
                        List<String> examen = parserSemester(strDis.get(2));
                        for (String b : examen) {
                            System.out.println((Integer.parseInt(b)-1)*step);
                            /*System.out.println("---" + ExcelParsing.readExcel(sheet2,g,sem1
                                    + (Integer.parseInt(b)-1)*step));*/
                            controlRepository.save(new Control(
                                    Double.parseDouble(ExcelParsing.readExcel(
                                            sheet,g,start + (Integer.parseInt(b)-1)*step)),
                                    Integer.parseInt(b),
                                    typeOfControlRepository.findTypeOfControlByNameTypeOfControl(controlType.get(2)).getCode_type_control(),
                                    disp.getCode_discipline()
                            ));
                        }
                    }

                    if (!strDis.get(5).equals("0")) {
                        List<String> examen = parserSemester(strDis.get(2));
                        for (String b : examen) {
                            System.out.println((Integer.parseInt(b)-1)*step);
                            /*System.out.println("---" + ExcelParsing.readExcel(sheet2,g,sem1
                                    + (Integer.parseInt(b)-1)*step));*/
                            controlRepository.save(new Control(
                                    Double.parseDouble(ExcelParsing.readExcel(
                                            sheet,g,start + (Integer.parseInt(b)-1)*step)),
                                    Integer.parseInt(b),
                                    typeOfControlRepository.findTypeOfControlByNameTypeOfControl(controlType.get(3)).getCode_type_control(),
                                    disp.getCode_discipline()
                            ));
                        }
                    }

                    if (!strDis.get(6).equals("0")) {
                        List<String> examen = parserSemester(strDis.get(2));
                        for (String b : examen) {
                            System.out.println((Integer.parseInt(b)-1)*step);
                            /*System.out.println("---" + ExcelParsing.readExcel(sheet2,g,sem1
                                    + (Integer.parseInt(b)-1)*step));*/
                            controlRepository.save(new Control(
                                    Double.parseDouble(ExcelParsing.readExcel(
                                            sheet,g,start + (Integer.parseInt(b)-1)*step)),
                                    Integer.parseInt(b),
                                    typeOfControlRepository.findTypeOfControlByNameTypeOfControl(controlType.get(4)).getCode_type_control(),
                                    disp.getCode_discipline()
                            ));
                        }
                    }

                    while (ExcelParsing.readExcel(sheet,2,fff) != null &
                            !ExcelParsing.readExcel(sheet,2,fff).equals("Наименование")) {
                        if(!ExcelParsing.readExcel(sheet,g,fff).equals("0")) {
                            List<String> listHour = ExcelParsing.readExcelCell(sheet, g, fff+1,fff+5);
                            int type = 0;
                            for (String l : listHour) {
                                rhdsRepository.save(new RHDS(
                                        Double.parseDouble(l),
                                        ((fff-17)/step)+1,
                                        typeOfActivityRepository.findTypeOfActivityByNameTypeOfActivity(activityType.get(type)).getCode_type_of_activity(),
                                        disp.getCode_discipline()
                                ));
                                type++;
                            }

                        }
                        fff+=step;
                    }
                    fff = sem2;
                }
            }
            g++;
        }
    }

    @GetMapping("/start")
    public ResponseEntity<String> startApp() {
        constValue.put("COMP_CODE", 2);
        constValue.put("TYPE_CONTROL", 2);
        constValue.put("START_TYPE_CONTROL", 3);
        constValue.put("START_TYPE_ACTIVITY", 18);
        constValue.put("LINE_DIRECTION", 17);
        constValue.put("COLUMN_DIRECTION", 1);
        constValue.put("LINE_STANDART", 30);
        constValue.put("COLUMN_STANDART", 19);
        constValue.put("LINE_PROFILE", 18);
        constValue.put("COLUMN_PROFILE", 1);
        constValue.put("LINE_YEAR", 28);
        constValue.put("COLUMN_YEAR", 19);
        constValue.put("LINE_STATEMENT", 12);
        constValue.put("LINE_STATEMENT", 12);
        constValue.put("COLUMN_STATEMENT", 0);
        constValue.put("LINE_QUALIFICATION", 28);
        constValue.put("COLUMN_QUALIFICATION", 0);
        constValue.put("LINE_FORM", 30);
        constValue.put("COLUMN_FORM", 0);
        constValue.put("START_DISCIPLINE",5);
        nameFile = null;

        return constValue!= null
                ? new ResponseEntity<>("sttart", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/admin")
    public ResponseEntity<Map> test3 () {


        return constValue!= null
                ? new ResponseEntity<>(constValue, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/7")
    public ResponseEntity<String> test1(
            @RequestParam(name = "file") MultipartFile file
    ) throws IOException, ClassNotFoundException, SQLException {

        try {
            file.transferTo(new File("C://Users//DaniilH//Desktop//demo2//itot4year//upload/" + file.getOriginalFilename()));
            nameFile = file.getOriginalFilename();
            String s = "Успех";
            HSSFSheet sheet = ExcelParsing.connectionSheet("C:\\Users\\DaniilH\\Desktop\\дашборд\\" + nameFile, SHEET.get("competencies"));
            HSSFSheet sheet2 = ExcelParsing.connectionSheet("C:\\Users\\DaniilH\\Desktop\\дашборд\\" + nameFile, SHEET.get("curricula"));
            List<String> controlType = ExcelParsing.readExcelCell(sheet2, 2, 3, 7);
            List<String> activityType = ExcelParsing.readExcelCell(sheet2, 2, 18, 22);
            HSSFSheet sheet3 = ExcelParsing.connectionSheet("C:\\Users\\DaniilH\\Desktop\\дашборд\\" + nameFile, SHEET.get("titlePage"));

            addCompetence(sheet); //компетенции
            addTypeControl(sheet2); //типы контроля
            addTypeActivity(sheet2); //типы занятий
            addStandart(sheet3); //стандарт
            addDirection(sheet3); //направление
            addProfile(sheet3); //профиль
            addProfileDirection(sheet3); //профиль направления
            addCurricula(sheet3); //учебный план
            addDisciplineAndControlAndActivity(sheet2, controlType, activityType); //дисциплины, контроль по ним, занятия по ним
            addCompetenciesDiscipline(sheet); //компетенции дисциплины



            return s != null
                    ? new ResponseEntity<>(s, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (IOException e) {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        finally {
           constValue.clear();
           startApp();
        }

    }


    @GetMapping("/test")
    public ResponseEntity<String[]> test2() throws IOException {
        HSSFSheet sheet3 = ExcelParsing.connectionSheet("C:\\Users\\DaniilH\\Desktop\\дашборд\\b09030204_20_1_II_plx_2.xls", SHEET.get("titlePage"));
        String d = ExcelParsing.readExcel(sheet3, 30, 19);
        String[] spl = d.split(" ");
        System.out.println(spl[2]);
        System.out.println(spl[4]);
        String mi = ExcelParsing.readExcel(sheet3, 17, 1).strip();
        int index = mi.indexOf(" ");
        System.out.println(mi.substring(index + 1));
        return spl != null
                ? new ResponseEntity<>(spl, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    String file_name = null;


    @PostMapping("/api/foos")
    @ResponseBody
    public String addFoo(@RequestParam(name = "file") MultipartFile file) throws IOException {
        file.transferTo(new File("C://Users//DaniilH//Desktop//demo2//itot4year//upload/" + file.getOriginalFilename()));
        return file.getOriginalFilename();
    }

    @GetMapping("/get-direction")
    private ResponseEntity<List> getDirection() {
        List<Direction> direct = directionRepository.findAll();
        return direct!= null
                ? new ResponseEntity<>(direct, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("get-profile")
    @Transactional(readOnly = true)
    public ResponseEntity<List> getProfile(
            @RequestParam String idDirection
    ) {

        List<Object> list = profileOfDirectionRepository.get_profile_of_direction(idDirection);
        return list!= null
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get-year")
    @Transactional(readOnly = true)
    public ResponseEntity<List> getYear(
            @RequestParam String idDirection,
            @RequestParam Integer idProfile
    ) {
        ProfileOfDirection pd = profileOfDirectionRepository
                .findProfileOfDirectionByCodeDirectionAndAndCodeProfile(
                        idDirection,
                        idProfile
                );
        List<Object> list = profileOfDirectionRepository.get_curricula(pd.getId_pd());
        return list!= null
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/get-curricula")
    @Transactional(readOnly = true)
    public ResponseEntity<List> getCurricula(
            @RequestParam String idDirection,
            @RequestParam Integer idProfile,
            @RequestParam Integer year
    ) {
        ProfileOfDirection pd = profileOfDirectionRepository
                .findProfileOfDirectionByCodeDirectionAndAndCodeProfile(
                        idDirection,
                        idProfile
                );
        List<Curricula> list = curriculaRepository.findCurriculaByIdPdAndYearStartTraining(
                pd.getId_pd(),
                year
        );
        return list!= null
                ? new ResponseEntity<>(list, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //public ResponseEntity<List> getDiscipline(){}
}
