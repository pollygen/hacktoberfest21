@echo off
echo StrText="HACKTOBERFEST21 IS AWESOME 👍" > spk.vbs
echo set ObjVoice=CreateObject("SAPI.SpVoice") >> spk.vbs
echo ObjVoice.Speak StrText >> spk.vbs
start spk.vbs
