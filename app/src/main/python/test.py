import sys
from os.path import dirname, join
from com.chaquo.python import Python
import timeout_decorator

def VariablesFirst(codeAreaData):

    x = [2, -4, 0, 7, 10, 100, 1000]
    y = [3, 7, 90, 60, 0, 24, 2000]

    # Mūsu programma, kas aprēķinās rezultātu salīdzināšanai.
    result = [0] * 7
    for i in range(7):
        result[i] = str(x[i] + y[i])

    for i in range(7):
        codeAreaDataT = codeAreaData + f"\n\nprint(twoDigitsSum({x[i]}, {y[i]}))"
        codeAreaDataT = test(codeAreaDataT)
        if codeAreaDataT == result[i] or codeAreaDataT == result[i] + '\n':
            continue
        else:
            return f"Tests [{i+1}]\n\nJūsu result vērtība:\n{codeAreaDataT}\n\nSagaidīta {result[i]}\n x = {x[i]}\n y = {y[i]}"
    return "Jūsu programma veiksmīgi izgāja visus testus."

def VariablesSecond(codeAreaData):

    x = [2, -4, 0, 7, 10, 100, 1000]
    y = [3, 7, 90, 60, 0, 24, 2000]

    # Mūsu programma, kas aprēķinās rezultātu salīdzināšanai.
    result = [0] * 7
    for i in range(7):
        result[i] = str(x[i] * y[i])

    for i in range(7):
        codeAreaDataT = codeAreaData + f"\n\nprint(twoDigitsMultiply({x[i]}, {y[i]}))"
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