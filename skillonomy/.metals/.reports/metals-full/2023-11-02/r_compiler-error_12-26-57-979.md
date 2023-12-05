file:///C:/Users/sj000/OneDrive/Documents/KSU/прога/scala/skillonomy/src/main/scala/classes/Course.scala
### scala.reflect.internal.FatalError: no context found for source-file:///C:/Users/sj000/OneDrive/Documents/KSU/прога/scala/skillonomy/src/main/scala/classes/Course.scala,line-2,offset=4

occurred in the presentation compiler.

action parameters:
offset: 4
uri: file:///C:/Users/sj000/OneDrive/Documents/KSU/прога/scala/skillonomy/src/main/scala/classes/Course.scala
text:
```scala

//@@класс курсов
class Course(name: String) {
    override def toString: String = name
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

scala.reflect.internal.FatalError: no context found for source-file:///C:/Users/sj000/OneDrive/Documents/KSU/прога/scala/skillonomy/src/main/scala/classes/Course.scala,line-2,offset=4