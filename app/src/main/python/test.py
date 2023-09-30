import sys
from os.path import dirname, join
from com.chaquo.python import Python
import timeout_decorator

def ProgrammingBasicsFirst(codeAreaData):

    result = ["Hello World!"]
    codeAreaDataT = test(codeAreaData)
    if codeAreaDataT == result[0] or codeAreaDataT == result[0] + '\n':
        return "Your program passed all tests!"
    else:
        return f"Test [1]\n\nYour output:\n{codeAreaDataT}\n\nExpected: \n{result[0]}"


def ProgrammingBasicsSecond(codeAreaData):

    result = ["Hello World!"]
    codeAreaData += "\n\nprint(variableOuput())"
    codeAreaDataT = test(codeAreaData)
    if codeAreaDataT == result[0] or codeAreaDataT == result[0] + '\n':
        return "Your program passed all tests!"
    else:
        return f"Test [1]\n\nYour output:\n{codeAreaDataT}\n\nExpected: \n{result[0]}"

def ProgrammingBasicsThird(codeAreaData):

    distance = [60, 35, 90, 6, 10, 100, 1000, 90, 45, 65, -200, 2150, -1, 5, 9]
    time = [5, 7, 90, 60, 2, 5, 2000, 4, 75, 15, 20, 50, 2, 50, 90000000]

    # Mūsu programma, kas aprēķinās rezultātu salīdzināšanai.
    result = [0] * 15
    for i in range(15):
        result[i] = str(distance[i] /  time[i])

    for i in range(15):
        codeAreaDataT = codeAreaData + f"\n\nprint(calculateSpeed({distance[i]}, {time[i]}))"
        codeAreaDataT = test(codeAreaDataT)
        if codeAreaDataT == result[i] or codeAreaDataT == result[i] + '\n':
            continue
        else:
            return f"Tests [{i+1}]\n\nJūsu result vērtība:\n{codeAreaDataT}\n\nSagaidīta {result[i]}\n x = {x[i]}\n y = {y[i]}"
    return "Jūsu programma veiksmīgi izgāja visus testus."


@timeout_decorator.timeout(5)
def test(codeAreaData):

    file_dir = str(Python.getPlatform().getApplication().getFilesDir())
    filename = join(dirname(file_dir), 'file2.txt')

    try:
        pass

        original_stdout = sys.stdout

        sys.stdout = open(filename, 'w', encoding='utf-8', errors="ignore")

        exec(codeAreaData)

        sys.stdout.close()

        sys.stdout = original_stdout

        output = open(filename, 'r').read()

    except Exception as e:

        sys.stdout = original_stdout
        output = e

    return str(output)