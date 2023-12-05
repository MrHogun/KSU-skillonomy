file:///C:/Users/sj000/OneDrive/Documents/KSU/прога/scala/skillonomy/src/main/scala/Course.scala
### scala.reflect.internal.FatalError: no context found for source-file:///C:/Users/sj000/OneDrive/Documents/KSU/прога/scala/skillonomy/src/main/scala/Course.scala,line-2,offset=6

occurred in the presentation compiler.

action parameters:
offset: 6
uri: file:///C:/Users/sj000/OneDrive/Documents/KSU/прога/scala/skillonomy/src/main/scala/Course.scala
text:
```scala

//кл@@асс курсов
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

scala.reflect.internal.FatalError: no context found for source-file:///C:/Users/sj000/OneDrive/Documents/KSU/прога/scala/skillonomy/src/main/scala/Course.scala,line-2,offset=6