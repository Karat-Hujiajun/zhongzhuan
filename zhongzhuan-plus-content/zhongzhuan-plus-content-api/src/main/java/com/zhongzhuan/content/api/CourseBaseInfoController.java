package com.zhongzhuan.content.api;

@Api(value = "课程信息管理接口", tags = "课程信息管理接口")
@ResController
public class CourseBaseInfoController {
    @Autowired
    CourseBaseInfoService courseBaseInfoService;
    @ApiOpreation("课程查询接口")
    @PostMapping("/cource/list")
    public PageResult<T> list(PageParams pageParam, @RequestBody(required=false) QueryCourseParamsDto queryCourseParamsDto){

        PageResult<CourseBase> courseBasePageResult = courseBaseInfoService.queryCourseBaseList(pageParam, queryCourseParamsDto);
        return courseBasePageResult;

    }

    @Api0peration("新增课程")
    @PostMapping("/content/course")
    public CourseBaseInfoDto createCourseBase(@RequestBody @Validated(ValidationGroups.Inster.class) AddCourseDto addCourseDto){
        //获取到用户所属机构的id
        Long companyId = 1232141425L;

        CourseBaseInfoDto courseBase = courseBaseInfoService.createcourseBase(companyId, addcourseDto);
        return courseBase;
    }

    @Api0peration("根据课程id查询接口")
    @GetMapping("/course/{courseId}")
    public CourseBaseInfoDto getCourseBaseInfo(@PathVariable long courseId){
        return courseBaseInfoService.getCourseBaseInfo(courseId);
    }

    @Api0peration("修改课程")
    @PutMapping(@~"/course")
    public CourseBaseInfoDto modifyCourseBase(EditCourseDto @Validated(ValidationGroups.Update.class) editcourseDto){
}
