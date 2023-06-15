import java.util.ArrayList;
import java.util.List;

public static String s = ""

public class SubstringGrouping {
    public static List<String> groupSubstrings(String s) {
        List<String> substrings = new ArrayList<>();
        int length = s.length();
        int startIndex = 0;
        int endIndex = 1800;

        while (startIndex < length) {
            if (endIndex > length) {
                endIndex = length;
            }

            String substring = s.substring(startIndex, endIndex);
            substrings.add(substring);

            startIndex = endIndex;
            endIndex += 1800;
        }

        return substrings;
    }

    public static void main(String[] args) {
        String input = "Resumo Este artigo investiga como os sistemas IAM são importantes para a computação em nuvem, como eles são implementados, os maiores desafios enfrentados ao lidar com esses sistemas e mais detalhes como vantagens e o que está sendo feito no estado da arte sobre o assunto. A metodologia envolve a pesquisa entre sites e artigos para descobrir o que há de mais relevante sobre o IAM na nuvem. As contribuições deste artigo são organizar de forma simples e compreensível o que se precisa saber sobre o sistema IAM, e o que este tema engloba na indústria e na academia. Palavras-chave: IAM, segurança de computação em nuvem, segurança, autenticação de dois fatores, autenticação multifator, segurança. Introdução Com a rápida adoção de sistemas computacionais baseados na nuvem a segurança se torna cada dia um questão que deve ser tomada a sério na mesma escala, devido ao fato que é desejado que os usuários possam ter acessos aos recursos de maneira segura e precisa, e é nisso que os sistemas IAM (Identity and Access Management) provam ter uma grande eficiência. Os sistemas IAM são sistemas de gerenciamento de acesso e identidade, e garantem que as pessoas certas de acordo com os respectivos cargos na organização, tenham acesso aos recursos corretos como e-mails, bases de dados, funcionalidades e/ou privilégios em softwares. Visão geral dos itens mais importantes do IAM Autenticação multifator (MFA): engloba a autenticação de dois fatores (2FA) que funciona como como o nome já induz, um ou mais fatores de autenticação, incluindo alguma coisa que você sabe, algo que você tem ou algo que você é. Essas camadas extras de segurança funcionam para proteger as contas contra hackers que talvez conseguiram quebrar alguma senha, ou alguém que teve uma senha ou credenciais primárias roubadas. Um exemplo de autenticação MFA é por exemplo quando alguém está logando em um sistema online e é requerido uma senha, a parte que você sabe, um código que é enviado no celular que é a parte que você tem, e um reconhecimento facial que é algo que você é. Se algumas dessas validações falhar, o acesso é negado. Para o Acesso Controle de identidade: é responsável por dar ao usuário o privilégio designado a ele. Por exemplo, não queremos que funcionários de outros departamentos possam ter acesso a arquivos sensíveis do RH. Controle baseado em políticas: quando associado ao item anterior podem controlar a necessidade de login novamente. Alguns exemplos disso é quando passamos um determinado tempo sem usar o sistema, ou quando temos que alterar alguma senha. Desafios do IAM em ambiente de Nuvem Fadiga na senha do usuário: às vezes o número de senhas que um usuário deve lembrar são muitas, o que acaba gerando uma sobrecarga de lembrar de diferentes senhas. Isso sem contar o fato que alguns usuários guardam suas senhas em arquivos de texto o que gera uma insegurança evidente. Gerenciando acesso para trabalho remoto : do mesmo jeito que as aplicações em nuvem trouxeram a facillidade de acesso a sistemas de qualquer lugar bastando apenas uma conexão com a internet, uma outra preocupação é levantada, os aparelhos que conectam em um sistema podendo ser o celular do usuário entre outros, o que leva ao desafio de acesso em qualquer lugar, qualquer hora e de qualquer lugar. Manter todas integrações em funcionamento : devido ao fato de que um dos princípios para o funcionamento de vários sistemas IAM em nuvem é o Sign on único, isso significa que diversas aplicações deve estar com disponibilidade de modo contínuo o que significa que qualquer adição de um novo serviço ou módulo deve se garantir que a integração com os sistema IAM esteja correto. Bem como todas as futuras atualizações. Vantagens do IAM em ambiente de Nuvem Segurança aprimorada: O IAM permite um controle granular sobre quem tem acesso aos recursos da nuvem. Com ele, você pode definir políticas de acesso baseadas em funções e atributos, restringindo o acesso apenas às pessoas ou sistemas autorizados. Isso reduz o risco de acesso não autorizado e ajuda a proteger seus dados e recursos. Gerenciamento centralizado de identidades: O IAM centraliza o gerenciamento de identidades e acessos em um único local. Isso simplifica a administração, pois você pode criar, modificar ou revogar permissões de acesso em escala, para vários usuários e recursos, a partir de um painel de controle centralizado. Conformidade regulatória: Para organizações que precisam cumprir regulamentações específicas, o IAM facilita a implementação de políticas de segurança e conformidade. Você pode definir políticas de acesso que estejam em conformidade com os requisitos regulatórios e auditar facilmente quem acessou quais recursos e quando. Maior produtividade: Com o IAM, você pode conceder acesso apenas aos recursos necessários para cada usuário ou grupo de usuários. Isso garante que as pessoas tenham as permissões adequadas para realizar seu trabalho, aumentando a eficiência e evitando a necessidade de solicitar acesso adicional sempre que surgir uma nova demanda. Flexibilidade e escalabilidade: O IAM permite a criação e gerenciamento de grupos de usuários com diferentes níveis de permissões. Isso facilita a escalabilidade, à medida que sua organização cresce e mais usuários são adicionados. Além disso, o IAM pode ser integrado com outros serviços e ferramentas da nuvem, permitindo uma gestão mais abrangente e flexível. Rastreabilidade e auditoria: O IAM registra e rastreia todas as atividades relacionadas a identidades e acessos. Isso inclui informações sobre quem fez o quê, quando e em qual recurso. Esses logs de auditoria podem ser usados para fins de investigação, conformidade e solução de problemas. Em resumo, o uso do IAM na computação em nuvem oferece uma camada adicional de segurança, simplifica a administração de acessos, ajuda a cumprir regulamentações, aumenta a produtividade e oferece maior flexibilidade e escalabilidade para sua infraestrutura em nuvem. Detalhes Importantes sobre IAM em Nuvem Identidade: No contexto de IAM, uma identidade representa um usuário, dispositivo ou serviço que precisa ser autenticado e autorizado para acessar recursos. Cada identidade é única e é associada a um conjunto de atributos que definem suas características e permissões. Com isso temos que a autenticação e autorização se tornam detalhes cruciais para o funcionamento dos IAM. Políticas de Acesso: As políticas de acesso são regras definidas para controlar o acesso a recursos específicos. Elas podem ser baseadas em funções, atributos ou outros critérios. Por exemplo, uma política pode permitir que todos os membros de uma equipe acessem uma pasta compartilhada, enquanto restringe o acesso a outros usuários. Gerenciamento de Credenciais: IAM envolve o gerenciamento de credenciais, como senhas, chaves de API e certificados. É importante aplicar boas práticas de segurança no armazenamento e proteção dessas credenciais, para evitar o acesso não autorizado. Provisionamento e Desprovisionamento: O provisionamento refere-se ao processo de atribuir identidades, atributos e permissões a usuários e sistemas. O desprovisionamento, por sua vez, envolve a remoção dessas atribuições quando não são mais necessárias. Um bom sistema de IAM deve permitir a automação eficiente do provisionamento e desprovisionamento para garantir que as permissões sejam concedidas e revogadas de forma adequada. Auditoria e Monitoramento: IAM deve fornecer recursos de auditoria e monitoramento para rastrear atividades de acesso, detectar eventos suspeitos e facilitar a conformidade com regulamentações de segurança. Logs de auditoria são importantes para investigações de segurança, análise forense e geração de relatórios de conformidade. Federação de Identidade: A federação de identidade permite que identidades autenticadas sejam compartilhadas entre diferentes sistemas e organizações. Isso é útil em cenários de colaboração, onde usuários de diferentes organizações precisam acessar recursos uns dos outros sem a necessidade de criar identidades separadas. Single Sign-On (SSO): O SSO permite que os usuários acessem vários sistemas e aplicativos com um único conjunto de credenciais. Isso simplifica o processo de autenticação e melhora a experiência do usuário, reduzindo a necessidade de lembrar várias senhas. Controle de Privilégios: O controle de privilégios refere-se à atribuição de permissões com base nas funções e responsabilidades de um usuário. É importante garantir que apenas as permissões necessárias sejam concedidas a cada usuário, seguindo o princípio do privilégio mínimo necessário. Segregação de Deveres: A segregação de deveres envolve a divisão de funções e permissões de maneira que uma única pessoa não tenha acesso a todas as etapas críticas de um processo. Isso reduz o risco de fraude, erro ou abuso de privilégios. Provisionamento de Identidades: O provisionamento de identidades refere-se ao processo de criar, modificar e excluir contas de usuários e suas permissões. Automatizar esse processo pode agilizar a administração de usuários e garantir a consistência nas atribuições de permissões. Integração com Diretórios Corporativos: A integração com diretórios corporativos, como o Active Directory, permite que as organizações aproveitem as identidades existentes e as políticas de segurança já estabelecidas. Isso simplifica o gerenciamento de identidades e sincroniza as informações de usuários em vários sistemas. Principais Projetos que oferecem IAM em ambiente de Nuvem Amazon Web Services (AWS): A AWS oferece o serviço IAM como parte de sua plataforma de computação em nuvem. Ele permite que os usuários gerenciem permissões e acessos aos recursos da AWS, como instâncias EC2, S3, RDS e outros. Microsoft Azure: O Azure também possui um serviço IAM chamado Azure Active Directory (Azure AD). Ele fornece controle de acesso e gerenciamento de identidades para os recursos do Azure, incluindo máquinas virtuais, bancos de dados, serviços de armazenamento, entre outros. Google Cloud Platform (GCP): O GCP oferece o Google Cloud IAM, que permite gerenciar permissões e acessos a recursos como instâncias do Google Compute Engine, buckets do Google Cloud Storage e outros serviços da plataforma. Okta: Okta é uma plataforma de gerenciamento de identidade baseada em nuvem que fornece serviços de autenticação e autorização. Ela permite que as organizações gerenciem o acesso aos aplicativos e recursos, seja na nuvem ou localmente. OneLogin: OneLogin é outro serviço de gerenciamento de identidade em nuvem que oferece recursos como Single Sign-On (SSO), provisionamento de usuários e gerenciamento de acesso. Ele é amplamente utilizado para fornecer autenticação e controle de acesso a aplicativos em nuvem e locais. 6. IBM Cloud Identity and Access Management: A IBM oferece serviços de IAM como parte de sua plataforma de nuvem. Eles permitem que os usuários gerenciem identidades, acessem recursos e apliquem políticas de segurança em ambientes de nuvem híbrida. Tópicos Relacionados O gerenciamento de acesso e identidade conta com uma alguns pilares que merecem destaque, dentre os quais tem-se a Autorização, Autenticação, Gestão de Acessos; Acessos Privilegiados e Serviços de Separação de Tarefas relacionado ao ambiente de Nuvem. Autenticação No contexto do gerenciamento de acesso e identidade, de acordo com o estudo de Sharma, Dhote e Potey, a autenticação é o processo em que a identidade de uma entidade é verificada quando ela está tentando acessar um recurso protegido (Sharma et al., 2016, p. 172). Assim, a autenticação assume um papel muito importante e pode ser também considerada o primeiro passo no processo de segurança, uma vez que é responsável por garantir que apenas usuários autorizados tenham permissão para acessar algum recurso. Ao utilizar a autenticação gerenciamento de acesso e identidade na nuvem, quando um usuário tenta acessar um recurso protegido, ele deve fornecer informações de sua identificação a fim de verificar quem ele é. Essas informações usualmente incluem nome de usuário e uma senha. Ao fornecer essas credenciais, o sistema de autenticação faz a verificação numa base de dados que contém as informações de usuários, faz a confirmação da identidade do usuário, verificando se existe ou não correspondência para aquelas credenciais, e valida sua permissão para acessar os recursos desejados. É válido destacar também que a autenticação baseada somente nas credenciais como nome de usuário e senha pode ter certas limitações em relação à segurança. Tendo isso em vista, alguns métodos adicionais de autenticação podem ser adotados, como a autenticação multifator (MFA), que é responsável por adicionar uma camada adicional de segurança além da autenticação tradicional, como um código de verificação enviado por mensagem de texto para um dispositivo móvel, um token físico ou uma impressão digital. Ao implementar métodos de autenticação robustos no gerenciamento de acesso e identidade, as organizações podem garantir que apenas usuários legítimos tenham acesso aos recursos da nuvem, melhorando a proteção contra ameaças como acesso não autorizado e roubo de credenciais. Além disso, a autenticação adequada também é essencial para estar em conformidade com regulamentações de segurança e privacidade. Gerenciamento de Autorização Segundo Sharma, Dhote e Potey (2016), no contexto da segurança em nuvem, o gerenciamento de autorização desempenha um papel fundamental no processo de garantir que os usuários tenham os direitos apropriados para acessar recursos protegidos. Ele age como uma etapa subsequente à autenticação bem-sucedida e tem como objetivo aprovar ou desaprovar as necessidades de acesso dos usuários com base nas políticas de autorização da organização. Isso permite que as organizações controlem o acesso de maneira granular, garantindo que apenas usuários autorizados tenham permissões adequadas para acessar informações confidenciais ou realizar determinadas ações. Além disso, o gerenciamento de autorização possibilita uma adaptação dinâmica das permissões com base em alterações nas necessidades e funções dos usuários, garantindo uma abordagem flexível, porém segura, para o controle de acesso em ambientes de nuvem. A implementação da autorização ocorre por meio do controle de acesso, em que é definido as regras e políticas que determinam o que um usuário pode fazer e quais recursos ele pode acessar. Essas políticas são baseadas em diferentes modelos, como o controle de acesso baseado em função, atributos, políticas e contexto. O controle de acesso, por sua vez, leva em consideração fatores como funções, níveis de privilégio, atributos específicos do usuário e contexto operacional. Uma prática muito recomendada no gerenciamento de autorização é a utilização do princípio de privilégios mínimos, que define que os usuários devem ter apenas as permissões necessárias para realizar suas funções e tarefas específicas. A ideia é evitar a concessão de privilégios excessivos que possam aumentar os riscos de segurança, como acesso não autorizado ou uso indevido de recursos. Controle de Acesso Baseado em Função: Controle de Acesso Baseado em Função ou Role-Based Access Control (RBAC) é um modelo de autorização amplamente adotado, que atribui permissões de acesso com base nas funções desempenhadas pelos usuários dentro de uma organização. Nesse modelo, as permissões são associadas a funções específicas, e os usuários são atribuídos a essas funções com base em suas responsabilidades e necessidades de acesso. A definição dessas funções geralmente ocorre com base nas tarefas e atividades que são executadas pelos usuários dentro de uma organização. Controle de Acesso Baseado em Atributos: Controle de Acesso Baseado em Atributos ou Attribute-Based Access Control (ABAC) é um modelo de autorização mais flexível e granular, que leva em consideração atributos específicos do usuário, do ambiente e do recurso para determinar as permissões de acesso. Nesse modelo, políticas de acesso são definidas com base em combinações de atributos, como identidade do usuário, localização geográfica, horário, tipo de dispositivo e outros fatores contextuais com relevância. Tais políticas são usadas para avaliar as solicitações de acesso e conceder permissões com base nas condições estabelecidas. Controle de Acesso Baseado em Política: Controle de Acesso Baseado em Política ou Policy-Based Access Control (PBAC) trata-se de um modelo de autorização que permite que as permissões de acesso sejam definidas e aplicadas de acordo com políticas. As políticas de acesso especificam as condições e regras que devem ser cumpridas para que uma solicitação seja concedida. Essas políticas podem incluir critérios como identidade do usuário, localização, horário, nível de confiança, entre outros. Controle de Acesso Baseado em Contexto: O Controle de Acesso Baseado em Contexto ou Context-Based Access Control (CBAC) é um modelo de autorização que como o próprio nome sugere, considera o contexto em que um solicitação de acesso é feita para determinar as permissões. O contexto pode incluir informações como a localização geográfica, o horário, o tipo de dispositivo, a rede utilizada e outros fatores relevantes. Com base nessas informações contextuais, as decisões de acesso são tomadas, garantindo que as permissões sejam concedidas de acordo com o contexto específico da solicitação. Gestão de Acessos De acordo com Sharma, Dhote e Potey (2016), a gestão de acesso em nuvem (Cloud Access Management) é um conjunto de práticas, políticas e tecnologias utilizadas para gerenciar e controlar o acesso aos recursos e serviços de computação em nuvem, incluindo processos conhecidos como autenticação, autorização e auditoria. Esse conjunto de práticas e tecnologias têm como objetivo garantir que apenas usuários autorizados tenham acesso às informações e recursos disponíveis em ambiente de nuvem. Outra prática que se destaca pela importância nos dias atuais é o monitoramento e registro de atividades. O processo de monitoramento e registro das atividades dos usuários na nuvem auxilia na detecção de comportamentos suspeitos por parte dos indivíduos que utilizam os recursos oferecidos, identificação de violações de segurança e auxílio na investigação de incidentes que possam influenciar na segurança das informações e processos da organização. O monitoramento pode incluir o registro de logs, análise de comportamento, detecção de anomalias e sistemas de alerta. O processo que contribui e se destaca para a garantia e manutenção da segurança nas organizações que utilizam de serviços em nuvem é a criptografia, que se mostra fundamental na proteção, garantia da confidencialidade, integridade e autenticidade dos dados armazenados e transmitidos na nuvem, protegendo tanto os dados em trânsito (como comunicação eletrônica trocada entre duas ou mais partes) quantos os dados em repouso (como um arquivo em um disco rígido). Esse processo envolve a conversão de informações em um formato específico em que só pode ser descriptografado por meio de uma chave específica. Na criptografia em nuvem, protocolos de criptografia como o Transport Layer Security (TLS) e Secure Sockets Layer (SSL) são fortes aliados para estabelecer conexões seguras entre o cliente e o servidor em nuvem. Por fim, uma das práticas que se destaca na gestão de acesso é o gerenciamento de chaves de acesso. As chaves de acesso são utilizadas para autenticar e autorizar usuários e serviços na nuvem. Um sistema eficiente de gerenciamento de chaves é importante para garantir que as chaves sejam armazenadas de forma segura, revogadas quando necessário e gerenciadas adequadamente para evitar o acesso não autorizado. Ao implementar uma gestão de acesso em nuvem eficaz, as organizações podem garantir a segurança dos dados e recursos em nuvem, minimizar os riscos de violações de segurança e manter o controle sobre quem pode acessar quais informações. Acessos Privilegiados Em conformidade com Sharma, Dhote e Potey (2016), o gerenciamento de acessos privilegiados (Privileged Access Management - PAM) é uma prática essencial para garantir a segurança em ambientes de nuvem. O PAM se concentra na proteção e controle dos acessos de contas consideradas privilegiadas, como administradores de sistema, desenvolvedores, equipes de operações específicas e outros usuários com privilégios categorizados como elevados dentro de uma organização. Essas contas possuem amplo acesso aos recursos e dados críticos e confidenciais em um ambiente em nuvem, tornando as contas alvos valiosas para potenciais ataques. Primeiramente, em relação aos acessos privilegiados, se faz necessário estabelecer um inventário completo de todas as contas privilegiadas em um ambiente em nuvem. Isso inclui identificar todas as contas com privilégios elevados, suas permissões e os recursos aos quais têm acesso. O gerenciamento adequado dessas contas envolve a implementação de políticas para garantir que apenas usuários autorizados tenham acesso a essas contas e que elas sejam monitoradas e controladas adequadamente. Ademais, é fundamental implementar políticas de controle de acesso rigorosas para contas privilegiadas. Isso inclui a prática de atribuição mínima de privilégios, fornecendo apenas os acessos e recursos necessários para realizar as tarefas específicas de cada função. O acesso a contas privilegiadas deve ser restrito apenas a usuários autorizados pelas polícias organizacionais adotadas. Uma técnica comumente utilizada pelas organizações que vale ressaltar é a autenticação forte, que demonstra ser fundamental para proteger as contas privilegiadas. Além do uso de senhas fortes, é recomendado adotar autenticação multifator para contas privilegiadas. Isso requer a verificação de identidade por meio de múltiplos fatores, como senhas, tokens físicos ou aplicativos de autenticação, antes de permitir o acesso. Além disso, para evitar o uso indevido de contas privilegiadas, é recomendado a implementação de uma política de rotação regular de senhas. Isso garante que senhas antigas e potencialmente comprometidas sejam atualizadas, reduzindo o risco de ataques baseados em senhas antigas. O gerenciamento de acessos privilegiados em segurança em nuvem desempenha um papel crítico na mitigação de riscos e na proteção dos dados e recursos mais sensíveis. Implementar boas práticas de PAM ajuda a evitar violações de segurança, reduzindo a superfície de ataque e garantindo a conformidade com regulamentações vigentes relevantes. Serviços de Separação de Tarefas relacionado ao ambiente de Nuvem Podemos considerar também que de acordo com Segundo Sharma, Dhote e Potey (2016), a separação de tarefas, também conhecida como segregação de funções, é uma prática fundamental em segurança de nuvem para evitar conflitos de interesse, reduzir riscos e aumentar a transparência nas operações. Ela envolve a divisão de funções e responsabilidades entre diferentes usuários ou equipes, garantindo que uma única entidade não possua controle absoluto sobre todo o ambiente de nuvem. No contexto de segurança em nuvem, a separação de tarefas refere-se à prática de atribuir funções e responsabilidades distintas a diferentes usuários ou equipes para evitar a concentração excessiva de poder e reduzir o risco de abuso de privilégios. Isso é particularmente relevante em ambientes de nuvem, onde várias tarefas administrativas e de gerenciamento são executadas. Existem serviços e práticas relacionados à separação de tarefas em ambientes de nuvem que podem ser adotados para reforçar a segurança e a integridade dos sistemas como, contas e políticas de acesso granular, onde os provedores de serviços em nuvem oferecem recursos que permitem que diferentes usuários ou equipes tenham acesso apenas às funcionalidades e recursos necessários para realizar suas tarefas, evitando assim privilégios excessivos. A prática de realização de revisões periódicas e auditorias internas é de extrema importância nos ambientes em nuvem pois contribui para a manutenção da integridade dos sistemas. Essas revisões incluem análises de permissões de acesso, revisões de atividades registradas e verificações de conformidade com os requisitos regulatórios. Isso pode ajudar a identificar discrepâncias, detecção de anomalias e garantir que as políticas de separação de tarefas adotadas estejam sendo seguidas adequadamente. Ao implementar adequadamente serviços e práticas relacionadas à separação de tarefas, as organizações podem fortalecer a segurança e a governança em ambientes de nuvem, reduzindo os riscos associados a privilégios excessivos, acessos indevidos e conflitos de interesse. Conclusão O Gerenciamento de Acesso e Identidade (IAM) desempenha um papel crítico na proteção dos recursos da nuvem, garantindo que apenas usuários autorizados tenham acesso e privilégios apropriados. É essencial que as organizações priorizem o gerenciamento como parte de sua estratégia de segurança na nuvem e implementem as práticas recomendadas mencionadas neste artigo pois são baseadas em empresas e que são líderes no segmento de nuvem e lidam com o contexto de IAM em suas plataformas para milhares de usuários diariamente. Mantendo-se atualizadas com os avanços mais recentes no Cloud IAM, as organizações podem fortalecer sua postura de segurança e proteger seus dados e recursos contra ameaças cibernéticas em constante evolução, além de manter a produtividade em um contexto de utilização de milhares de usuários.";
        List<String> substrings = groupSubstrings(input);

        for (String substring : substrings) {
            System.out.println(substring);
        }
    }
}
