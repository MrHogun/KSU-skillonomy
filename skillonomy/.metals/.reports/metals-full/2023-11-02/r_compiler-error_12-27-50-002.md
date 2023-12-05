file:///C:/Users/sj000/OneDrive/Documents/KSU/прога/scala/skillonomy/src/main/scala/Teacher.scala
### scala.reflect.internal.FatalError: no context found for source-file:///C:/Users/sj000/OneDrive/Documents/KSU/прога/scala/skillonomy/src/main/scala/Teacher.scala,line-2,offset=5

occurred in the presentation compiler.

action parameters:
offset: 5
uri: file:///C:/Users/sj000/OneDrive/Documents/KSU/прога/scala/skillonomy/src/main/scala/Teacher.scala
text:
```scala

//к@@ласс преподавателя
class Teacher(firstName: String, lastName: String, age: Int, var teachingCourses: List[Course]) extends Human(firstName, lastName, age) {
    override def toString: String = s"Teacher: ${super.toString}\nTeaching Courses: ${teachingCourses.mkString(", ")}"
  }
```



#### Error stacktrace:

```
scala.tools.nsc.interactive.CompilerControl.$anonfun$doLocateContext$1(CompilerControl.scala:100)
	scala.tools.nsc.interactive.CompilerControl.doLocateContext(CompilerControl.scala:100)
	scala.tools.nsc.interactive.CompilerControl.doLocateContext$(CompilerControl.scala:99)
	scala.tools.nsc.interactive.Global.doLocateContext(Global.scala:113)
	scala.meta.internal.pc.PcDefinitionProvider.definitionTypedTreeAt(PcDefinitionProvider.scala:151)
	scala.meta.internal.pc.PcDefinitionProvider.definition(PcDefinitionProvider.scala:68)
	scala.meta.internal.pc.PcDefinitionProvider.definition(PcDefinitionProvider.scala:16)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$definition$1(ScalaPresentationCompiler.scala:321)
```
#### Short summary: 

scala.reflect.internal.FatalError: no context found for source-file:///C:/Users/sj000/OneDrive/Documents/KSU/прога/scala/skillonomy/src/main/scala/Teacher.scala,line-2,offset=5