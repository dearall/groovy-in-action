def dircmd = ['cmd','/c','dir']
def dir = /C:\Program Files/
def proc = (dircmd + dir).execute()

InputStream in = proc.in
InputStream err = proc.err
OutputStream out = proc.out

proc.out << "one\n"
proc << "two\n"

println proc.text

proc.waitForOrKill(5000)