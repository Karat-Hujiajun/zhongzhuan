package com.zhongzhuan.content.api;

@Api(value = "课程信息管理接口", tags = "课程信息管理接口")
@ResController
public class CourseBaseInfoController {
    @ApiOpreation("课程查询接口")
    @PostMapping("/cource/list")
    public PageResult<T> list(PageParams PageParam, @RequestBody(required=false) QueryCourseParamsDto queryCourseParamsDto){
        CourseBase courseBase = new CourseBase();
        courseBase.setName("测试名称");
        courseBase.setCreateDate(LocalDateTime.now());
        List<CourseBase> courseBases = new ArrayList();
        courseBases.add(courseBase);
        PageResult pageResult = new PageResult<CourseBase>(courseBases,10,1,10);
        return pageResult;

    }
}
