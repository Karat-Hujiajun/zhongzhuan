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
        //当前登录用户
        SecurityUtil.XcUser user = SecurityUtil.getUser();
        //用户所属机构id
        Long companyId = null;
        if(StringUtils.isNotEmpty(user.getCompanyId())){
            companyId = Long.parseLong(user.getCompanyId());
        }


        PageResult<CourseBase> courseBasePageResult = courseBaseInfoService.queryCourseBaseList(companyId,pageParams, queryCourseParamsDto);
        return courseBase;
    }

    @Api0peration("根据课程id查询接口")
    @GetMapping("/course/{courseId}")
    public CourseBaseInfoDto getCourseBaseInfo(@PathVariable long courseId){
        //获取当前用户的身份
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(principal);
        SecurityUtil.XcUser user = SecurityUtil.getUser();
        System.out.println(user.getUsername());
        CourseBaseInfoDto courseBaseInfo = courseBaseInfoService.getCourseBaseInfo(courseId);
        return courseBaseInfoService.getCourseBaseInfo(courseId);
    }

    @Api0peration("修改课程")
    @PutMapping(@~"/course")
    public CourseBaseInfoDto modifyCourseBase(EditCourseDto @Validated(ValidationGroups.Update.class) editcourseDto){
}
