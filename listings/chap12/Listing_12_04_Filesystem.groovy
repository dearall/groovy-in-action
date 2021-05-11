import static groovy.io.FileType.DIRECTORIES
import static groovy.io.FileType.FILES

def topDir = new File('../chap09')
def srcDir = new File(topDir, 'src')

dirs = []
srcDir.eachDir { dirs << it.name }                                  //#A
assert  ['main', 'test'] == dirs

//Added by me 2021-05-8
println dirs

dirs = []
topDir.eachDirRecurse { dirs << it.name }                           //#B
assert dirs.containsAll(['gradle', 'src', 'main'])
assert dirs.containsAll(['groovy', 'services', 'wrapper'])

//Added by me 2021-05-8
println()
println dirs

dirs = []
topDir.eachDirMatch(~/[^l]*/) { dirs << it.name }                   //#C
assert dirs == ['src']

//Added by me 2021-05-8
println()
println dirs

files = []
topDir.eachFile { files << it.name }                                //#D
assert files.contains('Listing_09_01_ToStringDetective.groovy')
assert files.contains('src')

//Added by me 2021-05-8
println()
println files

files = []
topDir.eachFile(FILES) { files << it.name }                         //#E
assert files.contains('Listing_09_01_ToStringDetective.groovy')

//Added by me 2021-05-8
println()
println files

count = 0
srcDir.eachFileRecurse { if (it.directory) count++ }                //#F
assert 9 == count

count = 0
srcDir.eachFileRecurse(DIRECTORIES) { count++ }                     //#G
assert 9 == count

files = []
topDir.eachFileMatch(~/Listing_09_01.*/) { files << it.name }       //#H
assert ['Listing_09_01_ToStringDetective.groovy'] == files

//Added by me 2021-05-8
println()
println files
//#A Closure recording directory names
//#B Recursively record directory names
//#C Record directory names matching a pattern (.gradle is excluded here)
//#D Record filenames and directory names
//#E Record filenames
//#F Count directory names recursively
//#G Count directory names recursively, alternative solution
//#H Record filenames and directory names matching a pattern
