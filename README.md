# For templates
Write needed values in /command/template/whats.json

## Example (For Re152 version):
`build/template/whats.json`
```json
{
  "$deProjectName": "ReMine",
  "$deVersion": "1.5.2",
  "$deJavaVersion": "21",
  "$deMainClass": "net.minecraft.client.Minecraft",
  "$$repositories": [
    "https://maven.minecraftforge.net/",
    "https://www.beatunes.com/repo/maven2/",
    "https://repo.carm.cc/repository/maven-public/",
    "https://repo.glaremasters.me/repository/public/",
    "https://nexus.velocitypowered.com/repository/maven-public/"
  ],
  "$$dependsImplements": [
    "com.jcraft:jogg:0.0.7",
    "com.jcraft:jorbis:0.0.17",
    "org.lwjgl:lwjgl:3.2.1",
    "org.lwjgl.lwjgl:lwjgl_util:2.9.1",
    "net.sourceforge.argo:argo:7.6",
    "com.paulscode:codecwav:20101023",
    "com.paulscode:codecjorbis:20101023",
    "com.paulscode:soundsystem:201809301515",
    "com.paulscode:librarylwjglopenal:20100824",
    "org.jdom:jdom:1.1.3",
    "org.bouncycastle:bcprov-jdk15on:1.47",
    "org.xerial:sqlite-jdbc:3.7.2"
  ],
  "$$dependsCompileOnly": []
}
```
